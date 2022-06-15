package com.xiao.quartzlearn.first;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;


/**
 * 包名:com.xiao.quartzlearn.first
 * 作者: lucky
 * 创建时间: 2022年06月15日 11:03:23
 * 注释：入门案例1
 */
public class QuartzTest {
    public static void main(String[] args) {
        try {
            Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();
            defaultScheduler.start();
            // 定义工作并将其绑定到我们的 HelloJob 类
            JobDetail job = newJob(HelloJob.class)
                    .withIdentity("job1", "group1")
                    .build();

            // 立即触发作业运行，然后每 40 秒重复一次
            Trigger trigger = newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInSeconds(5)
                            .repeatForever())
                    .build();

            // 告诉quartz使用我们的触发器安排工作
            defaultScheduler.scheduleJob(job, trigger);

//            defaultScheduler.shutdown();
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }

    }
}
