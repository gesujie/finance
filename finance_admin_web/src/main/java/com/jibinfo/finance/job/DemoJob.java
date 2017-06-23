package com.jibinfo.finance.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2017/4/26.
 */
@Component
public class DemoJob  extends BaseJob implements Job{
	// private static final Log log = LogFactory.getLog(DemoJob.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            TriggerKey triggerKey = context.getTrigger().getKey();
            Trigger.TriggerState state = context.getScheduler().getTriggerState(TriggerKey.triggerKey(triggerKey.getName(),triggerKey.getGroup()));
            super.saveLog(triggerKey, state);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }


}
