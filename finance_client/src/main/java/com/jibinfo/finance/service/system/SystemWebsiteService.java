package com.jibinfo.finance.service.system;

import com.jibinfo.finance.entity.system.SystemWebsite;
import com.jibinfo.finance.entity.system.SystemWebsiteExample;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.service.BaseService;

public interface SystemWebsiteService extends  BaseService<SystemWebsiteExample, SystemWebsite>{


	ResponseVo saveOrUpdate(SystemWebsite model);

    SystemWebsite findOne();
}
