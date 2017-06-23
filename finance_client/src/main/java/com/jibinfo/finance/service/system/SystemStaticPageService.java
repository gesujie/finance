package com.jibinfo.finance.service.system;

import com.jibinfo.finance.entity.system.SystemStaticPage;
import com.jibinfo.finance.entity.system.SystemStaticPageExample;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.service.BaseService;

public interface SystemStaticPageService extends  BaseService<SystemStaticPageExample, SystemStaticPage>{


    PageModel<SystemStaticPage> getData(Integer pageNumber, Integer pageSize,SystemStaticPage model);

    ResponseVo saveOrUpdate(SystemStaticPage model);

    ResponseVo delete(String ids);
}
