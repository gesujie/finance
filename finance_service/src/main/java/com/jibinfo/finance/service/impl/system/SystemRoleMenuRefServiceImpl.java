package com.jibinfo.finance.service.impl.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jibinfo.finance.entity.system.SystemMenu;
import com.jibinfo.finance.entity.system.SystemMenuExample;
import com.jibinfo.finance.entity.system.SystemResource;
import com.jibinfo.finance.entity.system.SystemResourceExample;
import com.jibinfo.finance.entity.system.SystemRoleMenuRef;
import com.jibinfo.finance.entity.system.SystemRoleMenuRefExample;
import com.jibinfo.finance.entity.system.SystemRoleMenuRefExample.Criteria;
import com.jibinfo.finance.mapper.system.SystemMenuMapper;
import com.jibinfo.finance.mapper.system.SystemResourceMapper;
import com.jibinfo.finance.mapper.system.SystemRoleMenuRefMapper;
import com.jibinfo.finance.model.JsTreeState;
import com.jibinfo.finance.model.JsTreeViewDiy;
import com.jibinfo.finance.service.system.SystemRoleMenuRefService;
import com.jibinfo.framework.constant.Constants;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.dao.base.BaseMapper;
import com.jibinfo.framework.service.AbstractBaseServiceEx;
import com.jibinfo.framework.utils.StringUtils;

@Service("systemRoleMenuRefService")
public class SystemRoleMenuRefServiceImpl extends
		AbstractBaseServiceEx<SystemRoleMenuRefExample, SystemRoleMenuRef>
		implements SystemRoleMenuRefService {
	private static final Integer FIRST_LEVLE = 1;

	private static final Integer SECOND_LEVLE = 2;

	private static final String ROOT_MENU = "0";

	@Resource
	private SystemRoleMenuRefMapper systemRoleMenuRefMapper;

	@Resource
	private SystemMenuMapper systemMenuMapper;

	@Resource
	private SystemResourceMapper systemResourceMapper;

	@Override
	public BaseMapper<SystemRoleMenuRefExample, SystemRoleMenuRef> getMapper() {
		return systemRoleMenuRefMapper;
	}

	@Override
	public ResponseVo getSystemMenu(String menuId, String roleId) {
		ResponseVo responseVo = new ResponseVo().successResponse();

		Integer level = FIRST_LEVLE;
		Long mid = 0L;
		if (!ROOT_MENU.equals(menuId)) {
			level = SECOND_LEVLE;
			int index = menuId.indexOf("_");
			mid = Long.valueOf(menuId.substring(index + 1));
		}

		List<JsTreeViewDiy> jtvList = new ArrayList<>();

		// 获取菜单树
		List<SystemMenu> menuList = getMenuJsTree(roleId, mid, jtvList);

		// 查询菜单下的资源树
		getResourceJsTree(roleId, level, mid, jtvList, menuList);

		responseVo.setBody(jtvList);

		return responseVo;
	}

	@Override
	public ResponseVo save(String roleId, String ids) {
		// 修改：先删除后添加
		ResponseVo responseVo = new ResponseVo().successResponse();

		// 删除该角色下的所有权限
		deleteSystemRef(roleId);

		// 添加该角色下的菜单资源关系
		insertSystemRef(roleId, ids);

		return responseVo;
	}

	/**
	 * 获取菜单树
	 * 
	 * @return
	 */
	private List<SystemMenu> getMenuJsTree(String roleId, Long mid,
			List<JsTreeViewDiy> jtvList) {
		SystemMenuExample mex = new SystemMenuExample();
		SystemMenuExample.Criteria mct = mex.createCriteria();
		mct.andIsDelEqualTo(Constants.NO_DEL);
		mct.andPidEqualTo(mid);
		List<SystemMenu> menuList = systemMenuMapper.selectByExample(mex);
		if (null != menuList && !menuList.isEmpty()) {
			for (SystemMenu systemMenu : menuList) {
				// 检查是否存在关系，selected
				JsTreeState state = new JsTreeState(false, this.checkSelected(
						roleId, systemMenu.getId(), 0L), false);
				JsTreeViewDiy jsTreeViewDiy = new JsTreeViewDiy("m_"
						+ systemMenu.getId(), systemMenu.getName(), "", state,
						true);
				jtvList.add(jsTreeViewDiy);
			}
		}
		return menuList;
	}

	/**
	 * 获取菜单下的资源树
	 * 
	 */
	private void getResourceJsTree(String roleId, Integer level, Long mid,
			List<JsTreeViewDiy> jtvList, List<SystemMenu> menuList) {
		if (level != FIRST_LEVLE && (null == menuList || menuList.isEmpty())) {
			SystemResourceExample rex = new SystemResourceExample();
			SystemResourceExample.Criteria rct = rex.createCriteria();
			rct.andIsDelEqualTo(Constants.NO_DEL);
			rct.andMenuIdEqualTo(mid);
			List<SystemResource> resourceList = systemResourceMapper
					.selectByExample(rex);
			if (null != resourceList && !resourceList.isEmpty()) {
				for (SystemResource systemResource : resourceList) {
					JsTreeState state = new JsTreeState(false,
							this.checkSelected(roleId, mid,
									systemResource.getId()), false);
					JsTreeViewDiy jsTreeViewDiy = new JsTreeViewDiy("m_" + mid
							+ "_r_" + systemResource.getId(),
							systemResource.getName(), "", state, false);
					jtvList.add(jsTreeViewDiy);
				}
			}
		}
	}

	/**
	 * 检查是否被选中
	 * 
	 * @return
	 */
	private boolean checkSelected(String roleId, Long menuId, Long resourceId) {
		boolean flag = false;// false不选中，true选中
		List<SystemRoleMenuRef> list = null;

		SystemRoleMenuRefExample example = new SystemRoleMenuRefExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsDelEqualTo(Constants.NO_DEL);
		criteria.andRoleIdEqualTo(Long.valueOf(roleId));
		criteria.andMenuIdEqualTo(menuId);
		if (resourceId == 0L) {
			list = systemRoleMenuRefMapper.selectByExample(example);

			// 查询该菜单下有多少资源
			SystemResourceExample srExample = new SystemResourceExample();
			srExample.createCriteria().andIsDelEqualTo(Constants.NO_DEL)
					.andMenuIdEqualTo(menuId);
			List<SystemResource> srList = systemResourceMapper.selectByExample(srExample);

			if (null != list && null != srList
					&& (srList.size() + 1 == list.size())) {
				flag = true;
			}
		} else {
			criteria.andResourceIdEqualTo(resourceId);
			list = systemRoleMenuRefMapper.selectByExample(example);
			if (null != list && !list.isEmpty()) {
				flag = true;
			}
		}

		return flag;
	}

	/**
	 * 删除该角色下的菜单资源关系
	 * 
	 * @param roleId
	 */
	private void deleteSystemRef(String roleId) {
		SystemRoleMenuRefExample example = new SystemRoleMenuRefExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleIdEqualTo(Long.valueOf(roleId));
		List<SystemRoleMenuRef> list = systemRoleMenuRefMapper
				.selectByExample(example);
		if (null != list && !list.isEmpty()) {
			for (SystemRoleMenuRef systemRoleMenuRef : list) {
				systemRoleMenuRef.setIsDel(Constants.YES_DEL);
				systemRoleMenuRef.setUpdatedDate(new Date());
				systemRoleMenuRefMapper.updateByPrimaryKey(systemRoleMenuRef);
			}
		}
	}

	/**
	 * 添加该角色下的菜单资源关系
	 * 
	 * @param roleId
	 * @param ids
	 */
	private void insertSystemRef(String roleId, String ids) {
		// m_? m_?_r_?格式
		if (StringUtils.isNotEmpty(ids)) {
			String[] idst = ids.split(",");
			for (String id : idst) {
				int rindex = id.indexOf("r");
				if (rindex != -1) {
					this.operateSelectedMenuResource(roleId, id, rindex);
				} else {
					this.operateSelectedMenu(roleId, id);
				}
			}
		}
	}

	/**
	 * 选中的是资源进行操作
	 */
	private void operateSelectedMenuResource(String roleId, String id,
			int rindex) {
		Long menuId;
		Long resourceId;
		menuId = Long.valueOf(id.substring(2, rindex - 1));// 截取菜单ID
		resourceId = Long.valueOf(id.substring(rindex + 2));// 截取资源ID

		// 添加菜单，不可以重复
		SystemRoleMenuRefExample srmrExample = new SystemRoleMenuRefExample();
		srmrExample.createCriteria().andIsDelEqualTo(Constants.NO_DEL)
				.andRoleIdEqualTo(Long.valueOf(roleId))
				.andMenuIdEqualTo(menuId).andResourceIdIsNull();
		List<SystemRoleMenuRef> list = systemRoleMenuRefMapper
				.selectByExample(srmrExample);
		if (!(null != list && !list.isEmpty())) {
			SystemRoleMenuRef mrecord = new SystemRoleMenuRef(null,
					Long.valueOf(roleId), menuId, null, new Date(), new Date(),
					Constants.NO_DEL);
			systemRoleMenuRefMapper.insert(mrecord);
		}

		// 添加该角色下的菜单+资源
		SystemRoleMenuRef mrRecord = new SystemRoleMenuRef(null,
				Long.valueOf(roleId), menuId, resourceId, new Date(),
				new Date(), Constants.NO_DEL);
		systemRoleMenuRefMapper.insert(mrRecord);
	}

	/**
	 * 选中的是菜单进行操作
	 */
	private void operateSelectedMenu(String roleId, String id) {
		// m_103
		Long menuId = Long.valueOf(id.substring(2));
		SystemRoleMenuRef precord = new SystemRoleMenuRef(null,
				Long.valueOf(roleId), menuId, null, new Date(), new Date(),
				Constants.NO_DEL);
		systemRoleMenuRefMapper.insert(precord);

		SystemMenuExample smExample = new SystemMenuExample();
		smExample.createCriteria().andIsDelEqualTo(Constants.NO_DEL)
				.andPidEqualTo(menuId);

		// 查询该菜单下的子菜单
		List<SystemMenu> menuList = systemMenuMapper.selectByExample(smExample);
		if (null != menuList && !menuList.isEmpty()) {
			for (SystemMenu systemMenu : menuList) {
				// 查看该菜单下是否有子菜单
				SystemMenuExample smExampleChild = new SystemMenuExample();
				smExampleChild.createCriteria()
						.andIsDelEqualTo(Constants.NO_DEL)
						.andPidEqualTo(systemMenu.getId());
				List<SystemMenu> MenuChildList = systemMenuMapper
						.selectByExample(smExampleChild);

				if (null != MenuChildList && !MenuChildList.isEmpty()) {
					for (SystemMenu systemMenuChild : MenuChildList) {
						this.insertMenuResourceRef(roleId,
								systemMenuChild.getId());
					}
				} else {
					this.insertMenuResourceRef(roleId, systemMenu.getId());
				}
			}
		} else {
			this.insertMenuResourceRef(roleId, menuId);
		}
	}

	/**
	 * 操作菜单资源关系表
	 */
	private void insertMenuResourceRef(String roleId, Long menuId) {
		SystemRoleMenuRef precord = new SystemRoleMenuRef(null,
				Long.valueOf(roleId), menuId, null, new Date(), new Date(),
				Constants.NO_DEL);
		systemRoleMenuRefMapper.insert(precord);

		SystemResourceExample srExample = new SystemResourceExample();
		srExample.createCriteria().andIsDelEqualTo(Constants.NO_DEL)
				.andMenuIdEqualTo(menuId);
		List<SystemResource> resourcesList = systemResourceMapper
				.selectByExample(srExample);
		if (null != resourcesList && !resourcesList.isEmpty()) {
			for (SystemResource systemResource : resourcesList) {
				SystemRoleMenuRef record = new SystemRoleMenuRef(null,
						Long.valueOf(roleId), menuId, systemResource.getId(),
						new Date(), new Date(), Constants.NO_DEL);
				systemRoleMenuRefMapper.insert(record);
			}
		}
	}
}
