package com.light.springboot.interceptor.schedule;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * @descrption:
 * @author: bubbles
 */
@Component("customAdaptableJobFactory")
public class CustomAdaptableJobFactory extends AdaptableJobFactory {

    @Autowired
    private AutowireCapableBeanFactory autowireCapableBeanFactory;

    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        Object object = super.createJobInstance(bundle);
        // 将任务实例纳入 Spring 容器中
        this.autowireCapableBeanFactory.autowireBean(object);
        return object;
    }
}