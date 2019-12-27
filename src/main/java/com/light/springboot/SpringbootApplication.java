package com.light.springboot;

import com.light.springboot.configure.DataSourceProperties;
import com.light.springboot.configure.EncodingConvertor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;

/**
 * @descrption:
 *          @SpringBootApplication该注解指定项目为springboot，
 *          由此类当作程序入口 自动装配 web 依赖的环境
 * @author: bubbles
 */
@SpringBootApplication
public class SpringbootApplication extends SpringBootServletInitializer {

    /**
     * @Desc:   让 SpringbootApplication 类继承 SpringBootServletInitializer 并重写 configure 方法
     * @Param:  [builder]
     * @Return: org.springframework.boot.builder.SpringApplicationBuilder
     * @Author: bubbles
     * @Date:   2019/12/27 15:32
     **/
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringbootApplication.class);
    }

    /** 
     * @Desc:   
     * @Param:  [args] 
     * @Return: void
     * @Author: bubbles
     * @Date:   2019/12/27 10:58
     **/
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootApplication.class, args);
        //context.getBean(DataSourceProperties.class).show();
        System.out.println(System.getProperty("file.encoding"));
        Map<String,EncodingConvertor> map = context.getBeansOfType(EncodingConvertor.class);
        System.out.println(map);
    }
}
