package com.jibinfo.finance.service.system;


import com.jibinfo.finance.entity.system.SystemSensitive;
import com.jibinfo.finance.entity.system.SystemSensitiveExample;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.service.BaseService;

public interface SystemSensitiveService extends BaseService<SystemSensitiveExample, SystemSensitive> {

	ResponseVo saveOrUpdate(SystemSensitive model);

	PageModel<SystemSensitive> getData(Integer pageNumber, Integer pageSize, SystemSensitive model);
	
	ResponseVo delete(String ids);
	
}
