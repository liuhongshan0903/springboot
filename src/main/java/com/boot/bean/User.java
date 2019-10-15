package com.boot.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
//引用配置文件到实体类中使用
@Component 
//引用前缀prefix
@ConfigurationProperties(prefix = "com.liu")
public class User   {
	
	@Value("${com.liu.name}")
	private String name; 
	
	@Value("${com.liu.company}")
	private String company; 
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
}
