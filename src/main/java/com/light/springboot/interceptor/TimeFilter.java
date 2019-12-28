package com.light.springboot.interceptor;

import javax.servlet.*;
import java.io.IOException;

/**
 * @descrption:
 * @author: bubbles
 */
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("===========初始化过滤器===============");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("filter 耗时：" + (System.currentTimeMillis()-start));
    }

    @Override
    public void destroy() {
        System.out.println("===========销毁过滤器===============");
    }
}
