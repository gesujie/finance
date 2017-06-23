package com.jibinfo.finance.service.impl.system;

import com.jibinfo.finance.entity.system.SystemUserRoleRef;
import com.jibinfo.finance.entity.system.SystemUserRoleRefExample;
import com.jibinfo.finance.mapper.system.SystemUserRoleRefMapper;
import com.jibinfo.finance.service.system.SystemUserRoleRefService;
import com.jibinfo.framework.constant.Constants;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.dao.base.BaseMapper;
import com.jibinfo.framework.service.AbstractBaseServiceEx;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("systemUserRoleRefService")
public class SystemUserRoleRefServiceImpl extends
		AbstractBaseServiceEx<SystemUserRoleRefExample, SystemUserRoleRef> implements
		SystemUserRoleRefService {

	@Resource
	private SystemUserRoleRefMapper systemUserRoleRefMapper;

	@Override
	public BaseMapper<SystemUserRoleRefExample, SystemUserRoleRef> getMapper() {
		return systemUserRoleRefMapper;
	}


	@Override
	public ResponseVo saveOrUpdate(SystemUserRoleRef model) {
		ResponseVo responseVo = new ResponseVo().successResponse();
		Date date = new Date();
		model.setUpdatedDate(date);

		try {
			SystemUserRoleRef byUserId = this.findByUserId(model.getUserId());
			if(null == byUserId){
                model.setCreatedDate(date);
                model.setIsDel(Constants.NO_DEL);
                systemUserRoleRefMapper.insertSelective(model);
            }
            else{
                byUserId.setRoleId(model.getRoleId());
                systemUserRoleRefMapper.updateByPrimaryKeySelective(byUserId);
            }
		} catch (Exception e) {
			e.printStackTrace();
			responseVo = new ResponseVo().failureResponse();
		}


		return responseVo;
	}

	@Override
	public SystemUserRoleRef findByUserId(Long userId) {
		SystemUserRoleRefExample example = new SystemUserRoleRefExample();
		example.createCriteria().andIsDelEqualTo(Constants.NO_DEL)
				.andUserIdEqualTo(userId);
		List<SystemUserRoleRef> systemUserRoleRefs = systemUserRoleRefMapper.selectByExample(example);
		if(null != systemUserRoleRefs && systemUserRoleRefs.size() > 0)
			return systemUserRoleRefs.get(0);
		return null;
	}
}
