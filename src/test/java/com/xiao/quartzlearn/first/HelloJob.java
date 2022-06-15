package com.xiao.quartzlearn.first;

import com.xiao.quartzlearn.tools.DFUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;
import java.util.StringJoiner;
import java.util.Timer;

/**
 * 包名:com.xiao.quartzlearn.first
 * 作者: lucky
 * 创建时间: 2022年06月15日 11:11:52
 * 注释：
 */
public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        StringJoiner outStr = new StringJoiner(" ")
                .add("HelloJob.execute")
                .add(DFUtil.format(new Date()))
                .add(Thread.currentThread().getName())
                .add(jobExecutionContext.getTrigger().getKey().getName());
        System.out.println(outStr);
    }
}
