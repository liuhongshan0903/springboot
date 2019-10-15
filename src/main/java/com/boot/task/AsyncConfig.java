package com.boot.task;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfig {
	
	/* 1、corePoolSize：核心线程数
     * 核心线程会一直存活，及时没有任务需要执行
     * 当线程数小于核心线程数时，即使有线程空闲，线程池也会优先创建新线程处理
     * 设置allowCoreThreadTimeout=true（默认false）时，核心线程会超时关闭
     */
    private int corePoolSize = 5;
	
   	/* 2、queueCapacity：任务队列容量（阻塞队列）
     * 当核心线程数达到最大时，新任务会放在队列中排队等待执行
     */
    private int queueCapacity = 10;
    
    /* 3、maxPoolSize：最大线程数
     * 当线程数>=corePoolSize，且任务队列已满时。线程池会创建新线程来处理任务
     * 当线程数=maxPoolSize，且任务队列已满时，线程池会拒绝处理任务而抛出异常
     */
    private int maxPoolSize = 10;
    
    /*
     * 线程空闲时间
     * 当线程空闲时间达到keepAliveTime时，线程会退出，直到线程数量=corePoolSize
     * 如果allowCoreThreadTimeout=true，则会直到线程数量=0
     */
    private int keepAliveSeconds = 120;
    
    
    
    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setKeepAliveSeconds(keepAliveSeconds);
        executor.initialize();
        return executor;
    }
}