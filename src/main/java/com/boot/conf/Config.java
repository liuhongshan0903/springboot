package com.boot.conf;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
/**
 * 基础配置类
 * @author yu
 *
 */
@SpringBootConfiguration  
public class Config {  
  
/**
 * 相当于用spring 配置文件来初始化的bean  
 * 这个bean 可以在任何地方注入引用
 * @return
 */
  @Bean  
  public String hello(){  
      return "Hello World";  
  } 
  
  /**
   * 相当于  方法名   就是id 
   * <bean id="hello" class="String"></bean>  
   */
} 