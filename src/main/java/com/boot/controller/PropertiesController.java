package com.boot.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.bean.User;

@RestController
public class PropertiesController {
	
	@Autowired
	private User user;
	
	@Value("${com.liu.name}")
	private String name;
	
	@Value("${com.liu.company}")
	private String company;
	
	
	/**
	 * 注入获得需要的配置参数
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getProperties")
	public String getProperties(){
		System.out.println("======!"+name+"====>"+company);
		return company+"====>"+name;
	}
	
	
	/**
	 * 注入对象 获得需要的配置参数
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getProperties1")
	public String getProperties1(){
		System.out.println("======!"+user.getName()+"====>"+user.getCompany());
		return user.getName()+"====>"+user.getCompany();
	}
}
