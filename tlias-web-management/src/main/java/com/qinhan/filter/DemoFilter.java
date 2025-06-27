package com.qinhan.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
//@WebFilter(urlPatterns = "/*") // 拦截所有请求
public class DemoFilter implements Filter {
    // 初始化的方法，web服务器启动的时候执行一次
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init 初始化方法运行了...");
    }

    // 拦截到请求之后执行，会执行多次
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("拦截到了请求...");
        // 放行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    // 销毁的方法，web服务器关闭的时候执行，只执行一次
    @Override
    public void destroy() {
        log.info("destory 销毁方法...");
    }
}
