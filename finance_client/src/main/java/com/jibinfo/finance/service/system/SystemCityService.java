package com.jibinfo.finance.service.system;


import java.util.List;

import com.jibinfo.finance.entity.system.SystemCity;
import com.jibinfo.finance.entity.system.SystemCityExample;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.service.BaseService;

public interface SystemCityService extends BaseService<SystemCityExample, SystemCity> {

	ResponseVo saveOrUpdate(SystemCity model);

	PageModel<SystemCity> getData(Integer pageNumber, Integer pageSize, SystemCity model);
	
	ResponseVo delete(String ids);
	
	String findMaxCode();

	List<Long> getCidByPid(Long provinceId);
}
