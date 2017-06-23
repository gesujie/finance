package com.jibinfo.finance.service.impl.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jibinfo.finance.entity.user.UserCode;
import com.jibinfo.finance.entity.user.UserCodeExample;
import com.jibinfo.finance.mapper.user.UserCodeMapper;
import com.jibinfo.finance.service.user.UserCodeService;
import com.jibinfo.framework.dao.base.BaseMapper;
import com.jibinfo.framework.service.AbstractBaseServiceEx;

@Service("userCodeService")
public class UserCodeServiceImpl extends
		AbstractBaseServiceEx<UserCodeExample, UserCode> implements
		UserCodeService {
	@Resource
	private UserCodeMapper userCodeMapper;

	@Override
	public BaseMapper<UserCodeExample, UserCode> getMapper() {
		return userCodeMapper;
	}
}
