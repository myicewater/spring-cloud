package com.jaxon.eureka.job;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail myJobDetail(){
        JobDetail jobDetail = JobBuilder.newJob(HiJob.class)
                .withIdentity("hiJob")
                //JobDataMap可以给任务execute传递参数
                .storeDurably()
                .build();
        return jobDetail;
    }
    @Bean
    public Trigger myTrigger(){
        Trigger trigger = TriggerBuilder.newTrigger()
                .forJob(myJobDetail())
                .withIdentity("hiJobTrigger")
//                .startNow()
                //.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever())
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
                .build();
        return trigger;
    }
}
