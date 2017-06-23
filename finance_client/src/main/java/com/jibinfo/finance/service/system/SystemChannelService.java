package com.jibinfo.finance.service.system;


import com.jibinfo.finance.entity.system.SystemChannel;
import com.jibinfo.finance.entity.system.SystemChannelExample;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.service.BaseService;

public interface SystemChannelService extends BaseService<SystemChannelExample, SystemChannel> {

	ResponseVo saveOrUpdate(SystemChannel model);

	PageModel<SystemChannel> getData(Integer pageNumber, Integer pageSize, SystemChannel model);
	
	ResponseVo delete(String ids);
	
}
