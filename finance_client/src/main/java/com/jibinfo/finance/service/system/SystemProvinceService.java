package com.jibinfo.finance.service.system;


import com.jibinfo.finance.entity.system.SystemProvince;
import com.jibinfo.finance.entity.system.SystemProvinceExample;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.service.BaseService;

public interface SystemProvinceService extends BaseService<SystemProvinceExample, SystemProvince> {

	ResponseVo saveOrUpdate(SystemProvince model);

	PageModel<SystemProvince> getData(Integer pageNumber, Integer pageSize, SystemProvince model);
	
	ResponseVo delete(String ids);
	
	String findMaxCode();
	
	//根据code获取省份信息
	SystemProvince findByCode(String code);
	
}
