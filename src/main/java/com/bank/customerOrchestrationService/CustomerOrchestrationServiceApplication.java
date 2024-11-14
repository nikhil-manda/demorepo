package com.bank.customerOrchestrationService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = "com.bank.customerOrchestrationService")
@EnableFeignClients
@EnableAsync
public class CustomerOrchestrationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerOrchestrationServiceApplication.class, args);
	}

}
