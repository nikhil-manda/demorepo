package com.bank.customerOrchestrationService.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.bank.customerOrchestrationService.feign.service2Feign;
import com.bank.customerOrchestrationService.model.DetailsV2;
import com.bank.customerOrchestrationService.model.PhoneV2;
import com.bank.customerOrchestrationService.model.customerV1;
import com.bank.customerOrchestrationService.model.customerV2;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ServiceImpl {

	@Autowired
	service2Feign feignService;
	
	@Async("executor")
	public CompletableFuture<String> getfromfeign() {
		log.info("started thread {}",Thread.currentThread().getName() );
		String x = feignService.getCustomer();
		log.info("completed thread {}",Thread.currentThread().getName() );
		return CompletableFuture.completedFuture(x);
		
	}
	
	public void mycopy(customerV1 cust1 , customerV2 cust2) {
		log.info("cust 1 : {} ", cust1 ); 
		log.info("cust 2 : {} ", cust2 ); 
		BeanUtils.copyProperties(cust1, cust2);
		DetailsV2 det2 = new DetailsV2();
		BeanUtils.copyProperties(cust1.getDetails(), det2);
		cust2.setDetails(det2);
		PhoneV2 p2 = new PhoneV2();
		BeanUtils.copyProperties(cust1.getDetails().getPhone(),p2 );
		p2.setPhone(1);
		cust2.getDetails().setPhone(p2);
		log.info("After copying"); 
		log.info("cust 1 : {} ", cust1 ); 
		log.info("cust 2 : {} ", cust2 ); 
		
	}
}
