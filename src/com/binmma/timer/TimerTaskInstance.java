package com.binmma.timer;

import java.util.TimerTask;

import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class TimerTaskInstance extends QuartzJobBean{


	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		JobDetail jobDetail = context.getJobDetail();
		JobDataMap jobDataMap = jobDetail.getJobDataMap();
		Object object = jobDataMap.get("key");
		System.out.println("定时器TimerTaskInstance启动了..."+object);
		
	}

}
