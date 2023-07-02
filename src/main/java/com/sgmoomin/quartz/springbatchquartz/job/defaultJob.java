package com.sgmoomin.quartz.springbatchquartz.job;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class defaultJob {

	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;

	@Bean
	@JobScope
	public Job startJob() {
		return (Job) jobBuilderFactory.get("startJob")
			.start(moominStep1())
			.next(moominStep2())
			.build();
	}

	@Bean
	@StepScope
	public Step moominStep1() {
		return stepBuilderFactory.get("moominStep1")
			.tasklet((contribution, chunkContext) -> {
				log.info(">>>>> moominStep1 START JOB");
				return RepeatStatus.FINISHED;
			})
			.build();
	}

	@Bean
	@StepScope
	public Step moominStep2() {
		return stepBuilderFactory.get("moominStep2")
			.tasklet((contribution, chunkContext) -> {
				log.info(">>>>> moominStep2 START JOB");
				return RepeatStatus.FINISHED;
			})
			.build();
	}

}
