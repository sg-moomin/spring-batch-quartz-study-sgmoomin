package com.sgmoomin.quartz.springbatchquartz.runnerScheduler;

import java.util.HashMap;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;

import com.sgmoomin.quartz.springbatchquartz.config.JobSchedulerConfig;
import com.sgmoomin.quartz.springbatchquartz.jobScheduler.JobConfigurations;

public class JobSchedulersCron extends JobSchedulerConfig {

    @Autowired
    private Scheduler scheduler;

    @Override
    protected void startSchedulerCron(ApplicationArguments args) {

        JobDetail jobDetail = buildJobDetail(JobConfigurations.class, "fileJob", "batch", new HashMap());
        Trigger trigger = buildJobTrigger("0/15 * * * * ?");
     
        try{
            scheduler.scheduleJob(jobDetail, (org.quartz.Trigger) trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    
    }
}
