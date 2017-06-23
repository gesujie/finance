package com.jibinfo.finance.service.system;

import com.jibinfo.finance.entity.system.SystemUserRoleRef;
import com.jibinfo.finance.entity.system.SystemUserRoleRefExample;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.service.BaseService;

public interface SystemUserRoleRefService extends  BaseService<SystemUserRoleRefExample, SystemUserRoleRef>{

	/**
	 * 保存修改角色信息
	 * @param model
	 * @return
	 */
	ResponseVo saveOrUpdate(SystemUserRoleRef model);

	SystemUserRoleRef findByUserId(Long userId);


}
