# 1.定时任务
## 1.1 定时任务，基本概念
在指定的时间执行指定的任务
- scheduler:调度器
- JobDetail:任务管理器，包含Job（Job接口的类)
- Trigger:触发器，规定何时执行，执行什么任务，怎么执行
## 1.2 Quarts入门

```java
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

```
## 1.3 触发器
一个Trigger（触发器）只能调度一个JobDetail（任务），多个Trigger（触发器）能调度一个任务。
![img.png](/image/img.png)
## 1.4 CronExpression
## 1.5 传入变量，依赖注入
## 1.6 Spring+Quartz
## 1.7 持久化
## 1.8 集群环境
## 1.9 分布式环境
# 2.Quartz详解
