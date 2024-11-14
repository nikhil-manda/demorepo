package com.bank.customerOrchestrationService;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class configureExecutor {

	@Bean(name ="executor")
	public Executor executor() {
		ThreadPoolTaskExecutor exec = new ThreadPoolTaskExecutor();
		exec.setMaxPoolSize(100);
		exec.setCorePoolSize(100);
		exec.setQueueCapacity(500);
		exec.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		exec.setThreadNamePrefix("mythread");
		exec.initialize();
		return exec;
	}
	
}
