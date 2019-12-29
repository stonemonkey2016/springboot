package com.light.springboot.configure;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.google.common.collect.Lists;
import com.light.springboot.interceptor.ListenerTest;
import com.light.springboot.interceptor.ServletTest;
import com.light.springboot.interceptor.TimeFilter;
import com.light.springboot.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @descrption:
 * @author: bubbles
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Value("${spring.datasource.username}")
    private String userName;

    @Autowired
    private Environment environment;

    @Autowired
    private TimeInterceptor timeInterceptor;

    public void show() {
        System.out.println("spring.datasource.userName=" + this.userName);
        System.out.println("spring.datasource.password=" + this.environment.getProperty("spring.datasource.password"));
        System.out.println("spring.datasource.driver-class-name=" + this.environment.getProperty("spring.datasource.driver-class-name"));
    }

    /**
     * @Desc: fastJson整合
     * @Param: []
     * @Return: org.springframework.boot.autoconfigure.web.HttpMessageConverters
     * @Author: bubbles
     * @Date: 2019/12/27 23:45
     **/
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();

        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);

        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);

        HttpMessageConverter<?> converter = fastJsonHttpMessageConverter;
        return new HttpMessageConverters(converter);
    }

    /**
     * @Desc: Servlet
     * @Param: []
     * @Return: org.springframework.boot.web.servlet.ServletRegistrationBean
     * @Author: bubbles
     * @Date: 2019/12/27 23:45
     **/
    //@Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new ServletTest(), "/servletTest");
    }

    /**
     * @Desc: Filter
     * @Param: []
     * @Return: org.springframework.boot.web.servlet.FilterRegistrationBean
     * @Author: bubbles
     * @Date: 2019/12/27 23:45
     **/
    //@Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        TimeFilter timeFilter = new TimeFilter();
        registrationBean.setFilter(timeFilter);
        List<String> urls = Lists.newArrayList();
        urls.add("/*");
        registrationBean.setUrlPatterns(urls);
        return registrationBean;
    }

    /**
     * @Desc: Listener
     * @Param: []
     * @Return: org.springframework.boot.web.servlet.ServletListenerRegistrationBean<com.light.springboot.interceptor.ListenerTest>
     * @Author: bubbles
     * @Date: 2019/12/27 23:48
     **/
    //@Bean
    public ServletListenerRegistrationBean<ListenerTest> servletListenerRegistrationBean() {
        return new ServletListenerRegistrationBean<>(new ListenerTest());
    }

    //@Override
    //public void addInterceptors(InterceptorRegistry registry) {
    //    registry.addInterceptor(timeInterceptor);
    //}

    /**
     * @Desc: 跨越配置 CORS
     * @Param: [registry]
     * @Return: void
     * @Author: bubbles
     * @Date: 2019/12/28 1:12
     **/
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/fastjson/**")
                .allowedOrigins("http://localhost:8088"); // 允许 8088 端口访问
    }

    /**
     * @Desc: swagger2 资源配置
     * @Param: [registry]
     * @Return: void
     * @Author: bubbles
     * @Date: 2019/12/28 3:18
     **/
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
