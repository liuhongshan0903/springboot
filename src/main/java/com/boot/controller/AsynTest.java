package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.service.AsynService;

/**
 * 测试同步 异步
 * @RestController自动返回的是json格式数据
 * 
 */
@RestController
public class AsynTest {
	
	@Autowired
	private AsynService service ;
	
	@GetMapping("/async")  
	public String test1() throws InterruptedException {  
		service.task1();  
		service.task2();  
	    System.out.println("释放请求");  
	    return "ok";  
	}  

}
