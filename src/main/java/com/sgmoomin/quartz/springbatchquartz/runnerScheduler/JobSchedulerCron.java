package com.sgmoomin.quartz.springbatchquartz.runnerScheduler;

import java.util.HashMap;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import com.sgmoomin.quartz.springbatchquartz.config.JobSchedulerConfig;
import com.sgmoomin.quartz.springbatchquartz.jobScheduler.JobConfiguration;

@Component
public class JobSchedulerCron extends JobSchedulerConfig {

    @Autowired
    private Scheduler scheduler;

    @Override
    protected void startSchedulerCron(ApplicationArguments args) {

        JobDetail jobDetail = buildJobDetail(JobConfiguration.class, "fileJob", "batch", new HashMap());
        Trigger trigger = buildJobTrigger("0/10 * * * * ?");
     
        try{
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    
    }


}
