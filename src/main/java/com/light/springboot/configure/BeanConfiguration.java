package com.light.springboot.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @descrption:
 * @author: bubbles
 */
//@Configuration
public class BeanConfiguration {

    @Bean
    @Profile("dev")
    public Runnable test1(){
        System.out.println("开发环境使用的Bean");
        return ()->{};
    }

    @Bean
    @Profile("test")
    public Runnable test2(){
        System.out.println("测试环境使用的Bean");
        return ()->{};
    }

    @Bean
    @Profile("pro")
    public Runnable test3(){
        System.out.println("生产环境使用的Bean");
        return ()->{};
    }

}
