package com.jaxon.eureka.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class HiJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Logger logger = LoggerFactory.getLogger(HiJob.class);

        try {
            long id = Thread.currentThread().getId();
            logger.info(id+" start");
            Thread.sleep(20000);
            logger.info(id+ " end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
