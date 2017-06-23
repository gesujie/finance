package com.jibinfo.finance.service.system;

import com.jibinfo.finance.entity.system.SystemRoleMenuRef;
import com.jibinfo.finance.entity.system.SystemRoleMenuRefExample;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.service.BaseService;

public interface SystemRoleMenuRefService extends
		BaseService<SystemRoleMenuRefExample, SystemRoleMenuRef> {
	ResponseVo getSystemMenu(String menuId, String roleId);

	ResponseVo save(String roleId, String ids);
}
