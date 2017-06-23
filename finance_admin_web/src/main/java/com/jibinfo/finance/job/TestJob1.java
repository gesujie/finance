package com.jibinfo.finance.job;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.*;

/**
 * Created by admin on 2017/4/27.
 */
public class TestJob1  extends BaseJob  implements Job{
    private static final Log log = LogFactory.getLog(TestJob1.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("this is TestJob1....\r\n");
        try {
            TriggerKey triggerKey = context.getTrigger().getKey();
            Trigger.TriggerState state = context.getScheduler().getTriggerState(TriggerKey.triggerKey(triggerKey.getName(),triggerKey.getGroup()));
            super.saveLog(triggerKey,state);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
