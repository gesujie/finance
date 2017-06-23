package com.jibinfo.finance.job;

import com.jibinfo.finance.entity.quartz.Quartz;
import com.jibinfo.finance.service.quartz.QuartzService;
import com.jibinfo.framework.spring.ContextHolder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by admin on 2017/4/26.
 */
@Component
public class MonitorJob  extends BaseJob implements Job{
    private static final Log log = LogFactory.getLog(MonitorJob.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            QuartzService quartzService = (QuartzService)ContextHolder.getBean("quartzService");
            List<Quartz> quartzs = quartzService.findByModuleInitEnd("SYSTEM");
            TriggerKey triggerKey = context.getTrigger().getKey();
            Trigger.TriggerState state = context.getScheduler().getTriggerState(TriggerKey.triggerKey(triggerKey.getName(),triggerKey.getGroup()));
            Scheduler scheduler = context.getScheduler();
            if(null != quartzs && quartzs.size() > 0){
                for (Quartz quartz : quartzs) {
                    Trigger.TriggerState triggerState = scheduler.getTriggerState(TriggerKey.triggerKey(quartz.getTriggerName(), quartz.getGroupName()));
                    String status = triggerState.name();
                    //quartz.setUpdatedDate(new Date());
                    quartz.setStatus(status);
                    quartzService.updateByPrimaryKeySelective(quartz);//修改定时任务的状态


                }
            }
            super.saveLog(triggerKey,state);
            log.info("\r\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
