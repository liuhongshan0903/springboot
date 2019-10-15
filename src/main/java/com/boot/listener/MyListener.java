package com.boot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("MyListener-----init----start------");
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("MyListener-----contextDestroyed----start------");
		
	}

}
