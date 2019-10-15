package com.boot;

import javax.sql.DataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 使用@SpringBootApplication注解，等价于同时使用@Configuration @EnableAutoConfiguration @ComponentScan
 * 这就是spring boot的核心功能，自动配置。就是根据当前引入的JAR包进行自动配置，比如：引入了jackson的jar包，那么就会自动配置json转换
 * EnableScheduling springboot对quartz调度任务的支持 
 *@EnableTransactionManagement 事物控制
 */
@ServletComponentScan
@EnableTransactionManagement
@EnableAsync  
@SpringBootApplication
//@EnableScheduling
public class TestBoot {

	/**
	 * txManagerDataSource 方式 其中 dataSource 框架会自动为我们注入 在Spring容器中，我们手工注解@Bean
	 * 将被优先加载，框架不会重新实例化其他的 PlatformTransactionManager 实现类。
	 */
	@Bean
	public PlatformTransactionManager txManagerDataSource(DataSource dataSource) {
		System.out.println("运行jdbc数据库的是："+dataSource.getClass());  
		return new DataSourceTransactionManager(dataSource);
		//http://localhost:8080/druid/login.html
	}
	
	

	public static void main(String[] args) {
		SpringApplication.run(TestBoot.class);
	}
}
