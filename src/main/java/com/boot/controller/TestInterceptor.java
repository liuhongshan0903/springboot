package com.boot.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.bean.BmsUser;

/**
 * TestInterceptor 测试拦截器
 * @RestController自动返回的是json格式数据
 * 
 */
@RestController
public class TestInterceptor {
	
	@ResponseBody
	@RequestMapping(value="/visit")
	public void testResful(){
		System.out.println("-====visit=====");
		
	}
	
	
	
	

}
