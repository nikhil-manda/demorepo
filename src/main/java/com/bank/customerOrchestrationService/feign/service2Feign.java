package com.bank.customerOrchestrationService.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@FeignClient(name = "customerOrchestrationService2", url = "http://localhost:8082")
@CircuitBreaker(name = "countriesCircuitBreaker", fallbackMethod = "getCountries")
public interface service2Feign {

	@GetMapping("/getFeign")
	String getCustomer() ;
	
	public default String getCountries(Throwable throwable) {
        return "Country service unavailable!";
    }

}