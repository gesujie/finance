package com.jibinfo.finance.service.demo;

import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.service.BaseService;
import com.jibinfo.finance.entity.demo.Demo;
import com.jibinfo.finance.entity.demo.DemoExample;

public interface DemoService extends BaseService<DemoExample, Demo> {
	
	Demo getDemo();

	ResponseVo save(Long id, String name);

	ResponseVo createAvatar();
	
}
