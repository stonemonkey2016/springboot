package com.light.springboot.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @descrption:
 * @author: bubbles
 */
@Configuration
public class WebConfig {

    @Value("${ds.userName}")
    private String userName;

    @Autowired
    private Environment environment;

    public void show(){
        System.out.println("ds.userName=" + this.userName);
        System.out.println("ds.password=" + this.environment.getProperty("ds.password"));
    }
}
