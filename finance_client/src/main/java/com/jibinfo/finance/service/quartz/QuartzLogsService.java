package com.jibinfo.finance.service.quartz;

import com.jibinfo.finance.entity.quartz.QuartzLogs;
import com.jibinfo.finance.entity.quartz.QuartzLogsExample;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.service.BaseService;

/**
 * Created by admin on 2017/4/24.
 */
public interface QuartzLogsService extends BaseService<QuartzLogsExample, QuartzLogs> {

    PageModel<QuartzLogs> getData(Integer pageNumber, Integer pageSize, QuartzLogs model);

    ResponseVo saveOrUpdate(QuartzLogs quartzLogs);


}
