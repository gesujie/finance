package com.jibinfo.finance.service.impl.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.jibinfo.finance.entity.system.SystemMenu;
import com.jibinfo.finance.entity.system.SystemMenuExample;
import com.jibinfo.finance.entity.system.SystemMenuExample.Criteria;
import com.jibinfo.finance.entity.system.SystemRoleMenuRef;
import com.jibinfo.finance.entity.system.SystemRoleMenuRefExample;
import com.jibinfo.finance.entity.system.SystemUserRoleRef;
import com.jibinfo.finance.entity.system.SystemUserRoleRefExample;
import com.jibinfo.finance.mapper.system.SystemMenuMapper;
import com.jibinfo.finance.mapper.system.SystemRoleMenuRefMapper;
import com.jibinfo.finance.mapper.system.SystemUserRoleRefMapper;
import com.jibinfo.finance.model.JsTreeState;
import com.jibinfo.finance.model.JsTreeView;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.system.SystemMenuService;
import com.jibinfo.finance.vo.system.MenuVO;
import com.jibinfo.framework.constant.Constants;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.dao.base.BaseMapper;
import com.jibinfo.framework.page.Paginator;
import com.jibinfo.framework.service.AbstractBaseServiceEx;
import com.jibinfo.framework.utils.StringUtils;

@Service("systemMenuService")
public class SystemMenuServiceImpl extends
		AbstractBaseServiceEx<SystemMenuExample, SystemMenu> implements
		SystemMenuService {
	private static final Log logger = LogFactory
			.getLog(SystemMenuServiceImpl.class);

	private static final Integer ROOT_MENU = 0, FIRST_LEVLE = 1,
			SECOND_LEVLE = 2, THIRD_LEVLE = 3;

	@Resource
	private SystemMenuMapper systemMenuMapper;

	@Resource
	private SystemUserRoleRefMapper systemUserRoleRefMapper;

	@Resource
	private SystemRoleMenuRefMapper systemRoleMenuRefMapper;


	@Override
	public BaseMapper<SystemMenuExample, SystemMenu> getMapper() {
		return systemMenuMapper;
	}

	@Override
	public List<MenuVO> findMenuList(Long userId) {
		SystemMenuExample example = this.getExample(ROOT_MENU.longValue(),
				FIRST_LEVLE, userId);
		List<SystemMenu> firstMenuList = null;
		if(null != example)
			firstMenuList = systemMenuMapper.selectByExample(example);
		return convertMenuList(firstMenuList, userId);
	}

	/**
	 * 封装显示的菜单信息
	 * 
	 * @param dbMenuList
	 * @return
	 */
	private List<MenuVO> convertMenuList(List<SystemMenu> dbMenuList,
			Long userId) {
		List<MenuVO> menuList = new ArrayList<MenuVO>();
		if (!CollectionUtils.isEmpty(dbMenuList)) {
			for (SystemMenu systemMenu : dbMenuList) {
				MenuVO menu = new MenuVO();
				BeanUtils.copyProperties(systemMenu, menu);
				SystemMenuExample example = this.getExample(systemMenu.getId(),
						SECOND_LEVLE, userId);
				List<SystemMenu> secondMenuList = null;
				if(null != example){
					secondMenuList = systemMenuMapper.selectByExample(example);
				}
				menu.setChildMenu(converBySecondMenuList(secondMenuList, userId));
				menuList.add(menu);
			}
		}
		return menuList;
	}

	private List<MenuVO> converBySecondMenuList(
			List<SystemMenu> secondMenuList, Long userId) {
		List<MenuVO> menuList = new ArrayList<MenuVO>();
		if (!CollectionUtils.isEmpty(secondMenuList)) {
			for (SystemMenu systemMenu : secondMenuList) {
				MenuVO menu = new MenuVO();
				BeanUtils.copyProperties(systemMenu, menu);
				SystemMenuExample example = this.getExample(systemMenu.getId(),
						THIRD_LEVLE, userId);
				List<SystemMenu> thirdMenuList = null;
				if(null != example)
					thirdMenuList = systemMenuMapper.selectByExample(example);
				menu.setChildMenu(converByThirdMenuList(thirdMenuList, userId));
				menuList.add(menu);
			}
		}
		return menuList;
	}

	private List<MenuVO> converByThirdMenuList(List<SystemMenu> thirdMenuList,
			Long userId) {
		List<MenuVO> menuList = new ArrayList<MenuVO>();
		if (!CollectionUtils.isEmpty(thirdMenuList)) {
			for (SystemMenu systemMenu : thirdMenuList) {
				MenuVO menu = new MenuVO();
				BeanUtils.copyProperties(systemMenu, menu);
				menuList.add(menu);
			}
		}
		return menuList;
	}

	/**
	 * 获取查询添加
	 * 
	 * @param pid
	 * @param level
	 * @param userId
	 *            根据用户id获取菜单权限
	 * @return
	 */
	private SystemMenuExample getExample(Long pid, Integer level, Long userId) {
		//超级管理员不用过滤相关的菜单权限信息
		if(userId.longValue() == 1){
			SystemMenuExample example = new SystemMenuExample();
			example.createCriteria().andIsDelEqualTo(Constants.NO_DEL)
					.andPidEqualTo(pid).andLevelEqualTo(level);
			example.setOrderByClause("sort asc");
			return example;
		}
		else {//非超级管理员过滤相关的权限信息
			SystemUserRoleRefExample surrExample = new SystemUserRoleRefExample();
			surrExample.createCriteria().andIsDelEqualTo(Constants.NO_DEL)
					.andUserIdEqualTo(userId);
			List<SystemUserRoleRef> systemUserRoleRefs = systemUserRoleRefMapper.selectByExample(surrExample);
			if(null == systemUserRoleRefs || systemUserRoleRefs.size() == 0){
				return null;
			}

			Long roleId = systemUserRoleRefs.get(0).getRoleId();
			SystemRoleMenuRefExample srmrExample = new SystemRoleMenuRefExample();
			srmrExample.createCriteria().andIsDelEqualTo(Constants.NO_DEL)
					.andRoleIdEqualTo(roleId).andResourceIdIsNull();//resourceId is null 表示是菜单
			List<SystemRoleMenuRef> systemRoleMenuRefs = systemRoleMenuRefMapper.selectByExample(srmrExample);
			List<Long> menuIdList = new ArrayList<>();
			menuIdList.add(-1L);
			if (systemRoleMenuRefs != null && systemRoleMenuRefs.size() > 0) {
				for (SystemRoleMenuRef systemRoleMenuRef : systemRoleMenuRefs) {
					menuIdList.add(systemRoleMenuRef.getMenuId());
				}
			}
			//XXX 查询menuList下的所有的菜单id，所有的父类的菜单id
			List<Long> midList = systemMenuMapper.findAllPidByMids(menuIdList);
			SystemMenuExample example = new SystemMenuExample();
			example.createCriteria().andIsDelEqualTo(Constants.NO_DEL)
					.andPidEqualTo(pid).andLevelEqualTo(level)
					.andIdIn(midList);
			example.setOrderByClause("sort asc");
			return example;
		}


	}

	@Override
	public PageModel<SystemMenu> getData(Integer pageNo, Integer rows,
			SystemMenu model) {
		SystemMenuExample example = new SystemMenuExample();

		Paginator paginator = new Paginator().getPaginator(pageNo, rows);

		Criteria createCriteria = example.createCriteria();
		createCriteria.andIsDelEqualTo(Constants.NO_DEL);
		example.setOrderByClause("ID desc");

		// ======================添加组装
		// start======================================
		if (null != model) {
			if (!StringUtils.isEmpty(model.getName())) {
				// Like 只进行右边匹配
				createCriteria.andNameLike(model.getName() + "%");
			}
			if (!StringUtils.isEmpty(model.getModuleUrl())) {
				// Like 只进行右边匹配
				createCriteria.andModuleUrlLike(model.getModuleUrl() + "%");
			}
		}
		// ======================添加组装 end======================================
		example.setPaginator(paginator);
		List<SystemMenu> selectByExample = systemMenuMapper
				.selectByExample(example);
		int total = systemMenuMapper.countByExample(example);
		PageModel<SystemMenu> pageModel = new PageModel<>(total,
				selectByExample);
		return pageModel;
	}

	@Override
	public ResponseVo getMenu(Integer level) {
		ResponseVo result = new ResponseVo().successResponse();
		try {
			SystemMenuExample example = new SystemMenuExample();
			example.createCriteria().andIsDelEqualTo(Constants.NO_DEL)
					.andLevelEqualTo(level);
			List<SystemMenu> list = systemMenuMapper.selectByExample(example);
			result.setBody(list);
		} catch (Exception e) {
			result = result.failureResponse("异常");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ResponseVo saveOrUpdate(SystemMenu model) {
		ResponseVo result = new ResponseVo().successResponse();
		try {
			Date date = new Date();
			model.setCreatedDate(date);
			model.setUpdatedDate(date);
			if (null == model.getId()) {
				model.setIsDel(Constants.NO_DEL);
				systemMenuMapper.insertSelective(model);
			} else {
				systemMenuMapper.updateByPrimaryKeySelective(model);
			}
		} catch (Exception e) {
			result = result.failureResponse("异常");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ResponseVo delete(String ids) {
		ResponseVo result = new ResponseVo().successResponse();
		try {
			String[] idArr = StringUtils.split(ids, ",");
			if (null != idArr && idArr.length > 0) {
				for (String id : idArr) {
					SystemMenu model = systemMenuMapper
							.selectByPrimaryKey(new Long(id));
					model.setUpdatedDate(new Date());
					model.setIsDel(Constants.YES_DEL);
					systemMenuMapper.updateByPrimaryKeySelective(model);
				}
			}
		} catch (Exception e) {
			result = result.failureResponse("异常");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ResponseVo getTreeJson(Long userId) {
		ResponseVo responseVo = new ResponseVo().successResponse();
		try {
			List<JsTreeView> jtvList = new ArrayList<>();
			JsTreeView jsTreeView = new JsTreeView();
			jsTreeView.setId("-1");
			jsTreeView.setText("系统菜单");
			jsTreeView.setState(new JsTreeState(true, false, false));
			jtvList.add(new JsTreeView());

			List<MenuVO> firstChildMenu = this.findMenuList(userId);
			getFirstChildMenu(jsTreeView, firstChildMenu);
			responseVo.setBody(jsTreeView);
		} catch (Exception e) {
			logger.error(e.getMessage().toString());
			responseVo = new ResponseVo().failureResponse();
		}
		return responseVo;
	}

	@Override
	public ResponseVo getChildMenuByPid(String menuId) {
		ResponseVo responseVo = new ResponseVo().successResponse();
		if (StringUtils.isEmpty(menuId)) {
			return new ResponseVo().failureResponse("请选择菜单节点添加！");
		}

		SystemMenuExample example = new SystemMenuExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsDelEqualTo(Constants.NO_DEL);
		criteria.andPidEqualTo(Long.valueOf(menuId));
		List<SystemMenu> list = systemMenuMapper.selectByExample(example);
		boolean flag = null != list && !list.isEmpty();
		if (flag) {
			return new ResponseVo().failureResponse("请选择最后一节节点！");
		}

		return responseVo;
	}

	/**
	 * 获取第一节菜单
	 * 
	 */
	private void getFirstChildMenu(JsTreeView jsTreeView,
			List<MenuVO> firstChildMenu) {
		if (null != firstChildMenu && !firstChildMenu.isEmpty()) {
			List<JsTreeView> firstChildren = new ArrayList<>();
			for (MenuVO firstChild : firstChildMenu) {
				JsTreeView firstjtvc = new JsTreeView();
				firstjtvc.setId(firstChild.getId() + "");
				firstjtvc.setState(new JsTreeState(true, false, false));
				firstjtvc.setText(firstChild.getName());
				List<MenuVO> secondChildMenu = firstChild.getChildMenu();
				getSecondChildMenu(firstjtvc, secondChildMenu);
				firstChildren.add(firstjtvc);
			}
			jsTreeView.setChildren(firstChildren);
		}
	}

	/**
	 * 获取第二节菜单
	 * 
	 */
	private void getSecondChildMenu(JsTreeView firstjtvc,
			List<MenuVO> secondChildMenu) {
		if (null != secondChildMenu && !secondChildMenu.isEmpty()) {
			List<JsTreeView> secondChildren = new ArrayList<>();
			for (MenuVO secondChild : secondChildMenu) {
				JsTreeView secondjtvc = new JsTreeView();
				secondjtvc.setId(secondChild.getId() + "");
				secondjtvc.setState(new JsTreeState(false, false,false));
				secondjtvc.setText(secondChild.getName());
				List<MenuVO> thirdChildMenu = secondChild
						.getChildMenu();
				getThirdChildMenu(secondjtvc, thirdChildMenu);
				secondChildren.add(secondjtvc);
			}
			firstjtvc.setChildren(secondChildren);
		}
	}

	/**
	 * 获取第三节菜单
	 */
	private void getThirdChildMenu(JsTreeView secondjtvc,
			List<MenuVO> thirdChildMenu) {
		if (null != thirdChildMenu
				&& !thirdChildMenu.isEmpty()) {
			List<JsTreeView> thirdChildren = new ArrayList<>();
			for (MenuVO thirdChild : thirdChildMenu) {
				JsTreeView thirdjtvc = new JsTreeView();
				thirdjtvc.setId(thirdChild.getId() + "");
				thirdjtvc.setState(new JsTreeState(false,
						false, false));
				thirdjtvc.setText(thirdChild.getName());
				thirdChildren.add(thirdjtvc);
			}
			secondjtvc.setChildren(thirdChildren);
		}
	}

}
