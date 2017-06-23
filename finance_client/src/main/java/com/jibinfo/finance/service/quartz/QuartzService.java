package com.jibinfo.finance.service.quartz;

import com.jibinfo.finance.entity.quartz.Quartz;
import com.jibinfo.finance.entity.quartz.QuartzExample;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.service.BaseService;

import java.util.List;

/**
 * Created by admin on 2017/4/24.
 */
public interface QuartzService extends BaseService<QuartzExample, Quartz> {

    PageModel<Quartz> getData(Integer pageNumber, Integer pageSize, Quartz model);

    List<Quartz> findByModule(String module);

    List<Quartz> findByModuleInitEnd(String module);

    ResponseVo saveOrUpdate(Quartz quartz);

    ResponseVo delete(String ids);

    Quartz findByGroup(String group);
}
