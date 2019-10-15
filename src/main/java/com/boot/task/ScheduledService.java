package com.boot.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


//@Component
//@Async
public class ScheduledService {
    @Scheduled(cron = "5 * * * * *")
    public void scheduled(){
    	System.out.println("=====>>>>>使用cron  {}"+System.currentTimeMillis()+"--thread-->"+Thread.currentThread().getName());
    }
    @Scheduled(fixedRate = 10000)
    public void scheduled1() {
    	System.out.println("=====>>>>>使用fixedRate{}"+ System.currentTimeMillis()+"--thread-->"+Thread.currentThread().getName());
    }
    @Scheduled(fixedDelay = 20000)
    public void scheduled2() {
    	System.out.println("=====>>>>>fixedDelay{}"+System.currentTimeMillis()+"--thread-->"+Thread.currentThread().getName());
    }
}
