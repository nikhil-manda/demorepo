package com.bank.customerOrchestrationService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bank.customerOrchestrationService.model.Address;
import com.bank.customerOrchestrationService.model.DetailsV1;
import com.bank.customerOrchestrationService.model.PhoneV1;
import com.bank.customerOrchestrationService.model.customerV1;
import com.bank.customerOrchestrationService.model.customerV2;
import com.bank.customerOrchestrationService.service.ServiceImpl;

@ExtendWith(MockitoExtension.class)
public class mytest {

	@InjectMocks
	ServiceImpl service;
	
	@Test
	public void mytest1() {
		customerV1 cust1 = new customerV1();
		customerV2 cust2 = new customerV2();
		cust1.setAge(21);
		cust1.setFirstName("nikhil");
		DetailsV1 detail1= new DetailsV1();
		Address add = new Address();
		add.setCity("vzm");
		add.setStreet(5);
		detail1.setAddress(add);
		PhoneV1 phone1 = new PhoneV1();
		phone1.setPhn(1);
		phone1.setPhoneNumber(2);
		detail1.setPhone(phone1);
		cust1.setDetails(detail1);
		
		service.mycopy(cust1, cust2);
	}
}
