package com.sgmoomin.quartz.springbatchquartz.jobScheduler;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import lombok.SneakyThrows;

public class JobConfigurations extends QuartzJobBean{

    @Autowired
    private Job job;

    @Autowired
    private JobLauncher jobLauncher;

    @SneakyThrows
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        
        System.out.print("JobConfiguration Start Job 2!");
        JobParameters jobParameter = new JobParametersBuilder()
            .addLong("regId2", new Date().getTime())
            .toJobParameters();
        jobLauncher.run(job, jobParameter);
     
    }    
}
