package com.bank.customerOrchestrationService.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorMsg {

	public String Code;
	public String details;
	public String details2;
	public LocalDateTime timestamp;
	public String uuid;
	
}
