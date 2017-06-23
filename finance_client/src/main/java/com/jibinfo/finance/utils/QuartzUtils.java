package com.jibinfo.finance.utils;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by admin on 2017/4/26.
 */
public class QuartzUtils {

    private static final SchedulerFactory sf = new StdSchedulerFactory();

	@SuppressWarnings("unchecked")
	public static Scheduler getScheduler(String fullClassName, String jobName,
			String groupName, String triggerName, String cron) {
        Scheduler sche = null;
        try {
            Class<? extends Job> jobClass = (Class<? extends Job>) Class.forName(fullClassName);//根据全路劲获取class
            Job jobObj = jobClass.newInstance();//根据class获取当前对象
            sche = sf.getScheduler();
            JobDetail job = JobBuilder.newJob(jobObj.getClass())
                    .withIdentity(jobName, groupName)
                    .build();

            CronTrigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity(triggerName, groupName)
                    .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                    .build();
            sche.scheduleJob(job, trigger);
        }  catch (Exception e) {
            e.printStackTrace();
        }
        return sche;
    }

    public static Scheduler getScheduler(Class<? extends Job> jobClass,String jobName,String groupName,String triggerName,String cron) {
        Scheduler sche = null;
        try {
            Job jobObj = jobClass.newInstance();//根据class获取当前对象
            sche = sf.getScheduler();
            JobDetail job = JobBuilder.newJob(jobObj.getClass())
                    .withIdentity(jobName, groupName)
                    .build();

            CronTrigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity(triggerName, groupName)
                    .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                    .build();
            sche.scheduleJob(job, trigger);
        }  catch (Exception e) {
            e.printStackTrace();
        }
        return sche;
    }

    public static Scheduler getScheduler() {
        Scheduler sche = null;
        try {
            sche = sf.getScheduler();
        }  catch (Exception e) {
            e.printStackTrace();
        }
        return sche;
    }


}
