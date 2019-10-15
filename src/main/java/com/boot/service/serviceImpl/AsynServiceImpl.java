package com.boot.service.serviceImpl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.boot.service.AsynService;
@Service
public class AsynServiceImpl implements AsynService {
	
	@Async  
	public void task1() throws InterruptedException{  
	    Thread.sleep(2000);  
	    System.out.println("完成任务1");  
	}  
	@Async  
	public void task2() throws InterruptedException{  
	    Thread.sleep(1000);  
	    System.out.println("完成任务2");  
	}  

}
