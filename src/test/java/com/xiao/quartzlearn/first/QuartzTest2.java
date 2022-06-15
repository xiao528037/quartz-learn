package com.xiao.quartzlearn.first;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;


/**
 * 包名:com.xiao.quartzlearn.first
 * 作者: lucky
 * 创建时间: 2022年06月15日 11:03:23
 * 注释：入门案例1
 */
public class QuartzTest2 {
    public static void main(String[] args) {
        try {
            Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();
            defaultScheduler.start();

            //在job中name和group可以确定一个job
            JobDetail job = newJob(HelloJob.class)
                    .withIdentity("job1", "group1")
                    .build();
            //name和grop也可以确定一个trigger
            Trigger trigger = newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInSeconds(1)
                            .repeatForever())
                    .build();
            Trigger trigger2 = newTrigger()
                    .withIdentity("trigger2", "group1")
                    .forJob("job1", "group1")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInSeconds(3)
                            .repeatForever())
                    .build();
            defaultScheduler.scheduleJob(job, trigger);
            //拿不到Jobdateil对象时，在trigger中指定job，在schedule直接调用trigger
            defaultScheduler.scheduleJob(trigger2);
            TimeUnit.SECONDS.sleep(6);
            defaultScheduler.shutdown();
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
