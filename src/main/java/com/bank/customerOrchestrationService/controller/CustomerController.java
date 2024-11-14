package com.bank.customerOrchestrationService.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.customerOrchestrationService.service.ServiceImpl;

@RestController
public class CustomerController {

	@Autowired
	ServiceImpl serv;
	
	@GetMapping("/getCustomer")
	String getCustomer() throws InterruptedException, ExecutionException {
		List<CompletableFuture<String>> l = new ArrayList<>(10);
		for(int i=0;i<10;i++) {
			CompletableFuture<String> s = serv.getfromfeign();
			l.add(s);
		}
		CompletableFuture.allOf(l.toArray(new CompletableFuture<?>[0])).join();
		l.forEach(future -> {
			try {
				System.out.println(future.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		System.out.println("hello");
		return "completed";
	}
}
