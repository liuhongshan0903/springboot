package com.boot.interceptor;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootConfiguration
public class Mvc extends WebMvcConfigurerAdapter {
    public void addInterceptors(InterceptorRegistry registry) {
        //在系统注册中心 中添加 拦截器
    	//addPathPatterns 所有匹配的路径  
    	//excludePathPatterns 所有不匹配的路径
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/visit").excludePathPatterns("/error");
    }
}	
