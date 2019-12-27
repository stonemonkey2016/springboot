package com.light.springboot.configure;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @descrption:
 * @author: bubblesp
 */
@Component
@ConfigurationProperties(prefix="ds")
@Getter @Setter
public class DataSourceProperties {

    private String userName;
    private String password;
    private String url;
    private String driverClassName;

    public void show(){
        System.out.println("ds.userName="+this.userName);
        System.out.println("ds.password="+this.password);
        System.out.println("ds.url="+this.url);
        System.out.println("ds.driverClassName="+this.driverClassName);
    }
}
