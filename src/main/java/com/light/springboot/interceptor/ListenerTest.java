package com.light.springboot.interceptor;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @descrption:
 * @author: bubbles
 */
public class ListenerTest implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("监听器初始化。。。");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
