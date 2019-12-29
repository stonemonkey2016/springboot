package com.light.springboot.configure;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @descrption:
 * @author: bubblesp
 */
@Component
@ConfigurationProperties(prefix="spring.datasource")
@Getter @Setter
public class DataSourceProperties {

    @Value("${spring.datasource.username}")
    private String userName;
    private String password;
    private String url;
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    public void show(){
        System.out.println("spring.datasource.driver-class-name="+this.driverClassName);
        System.out.println("spring.datasource.url="+this.url);
        System.out.println("spring.datasource.userName="+this.userName);
        System.out.println("spring.datasource.password="+this.password);
    }
}
