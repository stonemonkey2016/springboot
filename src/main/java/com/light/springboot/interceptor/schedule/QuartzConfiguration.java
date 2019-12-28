package com.light.springboot.interceptor.schedule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

/**
 * @descrption:
 * @author: bubbles
 */
//@Configuration
public class QuartzConfiguration {

    /**
     *  Job 工厂
     * @return
     */
    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean() {
        JobDetailFactoryBean factory = new JobDetailFactoryBean();
        factory.setJobClass(MyJob.class);
        return factory;
    }

    /**
     *  Trigger 工厂
     * @return
     */
    @Bean
    public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactory) {
        SimpleTriggerFactoryBean factory = new SimpleTriggerFactoryBean();
        factory.setJobDetail(jobDetailFactory.getObject());
        // 执行间隔时间
        factory.setRepeatInterval(5000);
        // 重复执行次数
        factory.setRepeatCount(3);
        return factory;
    }

    /**
     *  Trigger 工厂
     * @return
     */
    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetailFactoryBean jobDetailFactory) {
        CronTriggerFactoryBean factory = new CronTriggerFactoryBean();
        factory.setJobDetail(jobDetailFactory.getObject());
        factory.setCronExpression("0/5 * * * * ?");
        return factory;
    }

   /* @Bean
    public SchedulerFactoryBean schedulerFactoryBean(SimpleTriggerFactoryBean simpleTriggerFactory){
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setTriggers(simpleTriggerFactory.getObject());
        return factory;
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean cronTriggerFactory){
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setTriggers(cronTriggerFactory.getObject());
        return factory;
    }*/

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean cronTriggerFactory, CustomAdaptableJobFactory customAdaptableJobFactory){
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setTriggers(cronTriggerFactory.getObject());
        factory.setJobFactory(customAdaptableJobFactory);
        return factory;
    }
}