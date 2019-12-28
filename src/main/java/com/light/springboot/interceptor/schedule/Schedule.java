package com.light.springboot.interceptor.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @descrption:
 * @author: bubbles
 */
@Component
public class Schedule {

    @Scheduled(fixedRate = 2000)
    public void task() {
        System.out.println("Scheduled定时任务:" + new Date());
    }
}
