package com.boot;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.springframework.transaction.annotation.Transactional;

//@EnableTransactionManagement 如果mybatis中service实现类中加入事务注解，需要此处添加该注解
//@EnableTransactionManagement 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
//启动springboot时，必须开启事物 事物才有效
@EnableTransactionManagement
@SpringBootApplication
public class TestBootTransaction implements TransactionManagementConfigurer {

	/**
	 * jpa方式
	 */
	/*
	 * @Bean public Object testBean(PlatformTransactionManager
	 * platformTransactionManager) { System.out.println(">>>>>>>>>>" +
	 * platformTransactionManager.getClass().getName()); return new Object(); }
	 */

	/**
	 * txManagerDataSource 方式
	 * 
	 * 其中 dataSource 框架会自动为我们注入 在Spring容器中，我们手工注解@Bean 将被优先加载，框架不会重新实例化其他的
	 * PlatformTransactionManager 实现类。
	 * 
	 * @param dataSource
	 * @return
	 */
	/*
	 * @Bean public PlatformTransactionManager txManagerDataSource(DataSource
	 * dataSource) { return new DataSourceTransactionManager(dataSource); }
	 */

	@Resource(name = "txManager2")
	private PlatformTransactionManager txManager2;

	// 创建事务管理器1   dataSource
	@Bean(name = "txManager1")
	public PlatformTransactionManager txManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	// 创建事务管理器2  jpa
	@Bean(name = "txManager2")
	public PlatformTransactionManager txManager2(EntityManagerFactory factory) {
		return new JpaTransactionManager(factory);
	}
	
	/**
	 * 多个事物管理器时，@Transactional 默认返回 txManager2
	 * 实现接口 TransactionManagementConfigurer 方法，其返回值代表在拥有多个事务管理器的情况下默认使用的事务管理器
	 * @return
	 */
	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return txManager2;
	}

	public static void main(String[] args) {
		SpringApplication.run(TestBootTransaction.class);
	}
}
