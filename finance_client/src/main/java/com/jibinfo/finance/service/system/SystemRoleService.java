package com.jibinfo.finance.service.system;

import com.jibinfo.finance.entity.system.SystemRole;
import com.jibinfo.finance.entity.system.SystemRoleExample;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.service.BaseService;

public interface SystemRoleService extends  BaseService<SystemRoleExample, SystemRole>{

	PageModel<SystemRole> getData(Integer pageNumber, Integer pageSize, SystemRole model);
	
	ResponseVo delete(String ids);

	ResponseVo changeStat(Long id);

	ResponseVo saveOrUpdate(SystemRole role);
}
