package com.jibinfo.finance.service.impl.system;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jibinfo.finance.entity.system.SystemRole;
import com.jibinfo.finance.entity.system.SystemRoleExample;
import com.jibinfo.finance.entity.system.SystemRoleExample.Criteria;
import com.jibinfo.finance.mapper.system.SystemRoleMapper;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.system.SystemRoleService;
import com.jibinfo.framework.constant.Constants;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.dao.base.BaseMapper;
import com.jibinfo.framework.page.Paginator;
import com.jibinfo.framework.service.AbstractBaseServiceEx;
import com.jibinfo.framework.utils.StringUtils;

@Service("systemRoleService")
public class SystemRoleServiceImpl extends
		AbstractBaseServiceEx<SystemRoleExample, SystemRole> implements
		SystemRoleService {
	private static final String STAT_VALID = "1";

	private static final String STAT_INVALID = "2";

	@Resource
	private SystemRoleMapper systemRoleMapper;

	@Override
	public BaseMapper<SystemRoleExample, SystemRole> getMapper() {
		return systemRoleMapper;
	}

	@Override
	public PageModel<SystemRole> getData(Integer pageNumber, Integer pageSize,
			SystemRole model) {
		Paginator paginator = new Paginator()
				.getPaginator(pageNumber, pageSize);

		SystemRoleExample example = new SystemRoleExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsDelEqualTo(Constants.NO_DEL);
		example.setOrderByClause("id desc");

		if (null != model) {
			if (StringUtils.isNotEmpty(model.getRoleCode())) {
				criteria.andRoleCodeLike("%" + model.getRoleCode().trim() + "%");
			}
			if (StringUtils.isNotEmpty(model.getName())) {
				criteria.andNameLike("%" + model.getName().trim() + "%");
			}
			if (StringUtils.isNotEmpty(model.getStat())
					&& !StringUtils.equalsIgnoreCase("-1", model.getStat())) {
				criteria.andStatEqualTo(model.getStat());
			}
		}

		example.setPaginator(paginator);

		List<SystemRole> roles = systemRoleMapper.selectByExample(example);
		int total = systemRoleMapper.countByExample(example);
		PageModel<SystemRole> pageModel = new PageModel<>(total, roles);
		return pageModel;
	}

	@Override
	public ResponseVo changeStat(Long id) {
		ResponseVo responseVo = new ResponseVo().successResponse();

		SystemRole role = systemRoleMapper.selectByPrimaryKey(id);
		String stat = role.getStat();
		if (STAT_VALID.equals(stat)) {
			role.setStat(STAT_INVALID);
		}

		if (STAT_INVALID.equals(stat)) {
			role.setStat(STAT_VALID);
		}
		systemRoleMapper.updateByPrimaryKeySelective(role);

		return responseVo;
	}

	@Override
	public ResponseVo delete(String ids) {
		ResponseVo result = new ResponseVo().successResponse();
		String[] idArr = StringUtils.split(ids, ",");
		if (null != idArr && idArr.length > 0) {
			for (String id : idArr) {
				SystemRole model = systemRoleMapper
						.selectByPrimaryKey(new Long(id));
				model.setUpdatedDate(new Date());
				model.setIsDel(Constants.YES_DEL);
				systemRoleMapper.updateByPrimaryKeySelective(model);
			}
		}
		return result;
	}

	@Override
	public ResponseVo saveOrUpdate(SystemRole role) {
		ResponseVo result = new ResponseVo().successResponse();
		Long id = role.getId();
		if (null == id) {// 添加
			role.setStat(STAT_VALID);
			role.setCreatedDate(new Date());
			role.setUpdatedDate(new Date());
			role.setIsDel(Constants.NO_DEL);
			systemRoleMapper.insert(role);
		}

		if (null != id) {// 修改
			role.setUpdatedDate(new Date());
			systemRoleMapper.updateByPrimaryKeySelective(role);
		}
		return result;
	}

}
