package com.jibinfo.finance.job;

import com.jibinfo.finance.entity.quartz.Quartz;
import com.jibinfo.finance.entity.quartz.QuartzLogs;
import com.jibinfo.finance.service.quartz.QuartzLogsService;
import com.jibinfo.finance.service.quartz.QuartzService;
import com.jibinfo.framework.constant.Constants;
import com.jibinfo.framework.spring.ContextHolder;
import org.quartz.Trigger;
import org.quartz.TriggerKey;

import java.util.Date;

/**
 * Created by admin on 2017/4/27.
 */
public class BaseJob{

    /**
     * 保存日志
     * @param triggerKey
     * @param state
     */
    void saveLog(TriggerKey triggerKey,Trigger.TriggerState state){
        QuartzLogsService quartzLogsService = (QuartzLogsService) ContextHolder.getBean("quartzLogsService");
        QuartzService quartzService = (QuartzService)ContextHolder.getBean("quartzService");
        String group = triggerKey.getGroup();
        Quartz quartz = quartzService.findByGroup(group);
        if (quartz != null) {
            Date date = new Date();
            QuartzLogs logs = new QuartzLogs();
            logs.setQdate(date);
            logs.setUpdatedDate(date);
            logs.setCreatedDate(date);
            logs.setIsDel(Constants.NO_DEL);
            logs.setQid(quartz.getId());
            logs.setQname(quartz.getName());
            logs.setQstatus(state.name());
            quartzLogsService.saveOrUpdate(logs);

        }

    }


}
