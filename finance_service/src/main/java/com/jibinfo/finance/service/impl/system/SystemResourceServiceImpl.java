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
import com.jibinfo.finance.entity.system.SystemResourceExample.Criteria;
import com.jibinfo.finance.mapper.system.SystemMenuMapper;
import com.jibinfo.finance.mapper.system.SystemResourceMapper;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.system.SystemResourceService;
import com.jibinfo.framework.constant.Constants;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.dao.base.BaseMapper;
import com.jibinfo.framework.page.Paginator;
import com.jibinfo.framework.service.AbstractBaseServiceEx;
import com.jibinfo.framework.utils.StringUtils;

@Service("systemResourceService")
public class SystemResourceServiceImpl extends
		AbstractBaseServiceEx<SystemResourceExample, SystemResource> implements
		SystemResourceService {
	@Resource
	private SystemResourceMapper systemResourceMapper;

	@Resource
	private SystemMenuMapper systemMenuMapper;

	@Override
	public BaseMapper<SystemResourceExample, SystemResource> getMapper() {
		return systemResourceMapper;
	}

	@Override
	public PageModel<SystemResource> getData(Integer pageNumber,
			Integer pageSize, SystemResource model) {
		Paginator paginator = new Paginator()
				.getPaginator(pageNumber, pageSize);

		SystemResourceExample example = new SystemResourceExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsDelEqualTo(Constants.NO_DEL);
		example.setOrderByClause("id desc");

		example.setPaginator(paginator);

		if (null != model) {
			Long menuId = model.getMenuId();
			if (null != menuId) {
				List<Long> menuIds = this.getChildMenuIdByPid(menuId);
				criteria.andMenuIdIn(menuIds);
			}
			if (StringUtils.isNotEmpty(model.getValue())) {
				criteria.andValueLike("%" + model.getValue() + "%");
			}
			if (StringUtils.isNotEmpty(model.getName())) {
				criteria.andNameLike("%" + model.getName() + "%");
			}
		}

		List<SystemResource> resources = systemResourceMapper
				.selectByExample(example);
		int total = systemResourceMapper.countByExample(example);
		PageModel<SystemResource> pageModel = new PageModel<>(total, resources);
		return pageModel;
	}

	@Override
	public ResponseVo saveOrUpdate(SystemResource resource, String menuId) {
		ResponseVo result = new ResponseVo().successResponse();
		Long id = resource.getId();
		if (null == id) {// 添加
			resource.setMenuId(Long.valueOf(menuId));
			resource.setCreatedDate(new Date());
			resource.setUpdatedDate(new Date());
			resource.setIsDel(Constants.NO_DEL);
			systemResourceMapper.insert(resource);
		}
		if (null != id) {// 修改
			resource.setUpdatedDate(new Date());
			systemResourceMapper.updateByPrimaryKeySelective(resource);
		}
		return result;
	}

	@Override
	public ResponseVo delete(String ids) {
		ResponseVo result = new ResponseVo().successResponse();
		String[] idArr = StringUtils.split(ids, ",");
		if (null != idArr && idArr.length > 0) {
			for (String id : idArr) {
				SystemResource model = systemResourceMapper
						.selectByPrimaryKey(new Long(id));
				model.setUpdatedDate(new Date());
				model.setIsDel(Constants.YES_DEL);
				systemResourceMapper.updateByPrimaryKeySelective(model);
			}
		}
		return result;
	}

	@Override
	public List<Long> getChildMenuIdByPid(Long menuId) {
		List<Long> menuIds = new ArrayList<>();
		SystemMenuExample example = new SystemMenuExample();
		SystemMenuExample.Criteria criteria = example.createCriteria();
		criteria.andIsDelEqualTo(Constants.NO_DEL);
		criteria.andIdEqualTo(Long.valueOf(menuId));

		SystemMenuExample.Criteria cta = example.createCriteria();
		cta.andIsDelEqualTo(Constants.NO_DEL);
		cta.andPidEqualTo(Long.valueOf(menuId));

		example.or(cta);
		List<SystemMenu> list = systemMenuMapper.selectByExample(example);
		if (null != list && !list.isEmpty()) {
			for (SystemMenu systemMenu : list) {
				menuIds.add(systemMenu.getId());
			}
		}
		return menuIds;
	}

}
