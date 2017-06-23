package com.jibinfo.finance.listener;

import com.jibinfo.finance.entity.quartz.Quartz;
import com.jibinfo.finance.service.quartz.QuartzService;
import com.jibinfo.finance.utils.QuartzUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Scheduler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by admin on 2017/4/26.
 */
@Component
public class InitListener {

    private static final Log log = LogFactory.getLog(InitListener.class);

    @Resource
    private QuartzService quartzService;

    public void init() {
        try {
            log.info("init quartz list start  .>.>.>.>.>.>.>.>.>.>.>.>.>.>.>.>");

            List<Quartz> quartzs = quartzService.findByModule("SYSTEM");
            this.startQuartzs(quartzs);
            log.info("init quartz list end  <.<.<.<.<.<.<.<.<.<.<.<.<.<.<.<.");

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    /**
     * 启动相关的任务
     * @param quartzs
     * @throws Exception
     */
    private void startQuartzs(List<Quartz> quartzs) throws Exception{
        if(null != quartzs && quartzs.size() > 0){
            for (Quartz quartz : quartzs) {
                Scheduler scheduler = QuartzUtils.getScheduler(quartz.getFullClassName(), quartz.getJobName(), quartz.getGroupName(), quartz.getTriggerName(), quartz.getCron());
                scheduler.start();
           /* Trigger.TriggerState triggerState = sche.getTriggerState(TriggerKey.triggerKey("trigger1", "group1"));
            System.out.println(triggerState.name());*/
            }
        }
    }


}
