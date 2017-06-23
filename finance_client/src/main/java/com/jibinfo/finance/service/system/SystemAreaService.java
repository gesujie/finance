package com.jibinfo.finance.service.system;


import com.jibinfo.finance.entity.system.SystemArea;
import com.jibinfo.finance.entity.system.SystemAreaExample;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.service.BaseService;

public interface SystemAreaService extends BaseService<SystemAreaExample, SystemArea> {

	ResponseVo saveOrUpdate(SystemArea model);

	PageModel<SystemArea> getData(Integer pageNumber, Integer pageSize, SystemArea model);
	
	ResponseVo delete(String ids);
	
	String findMaxCode();
	
}
