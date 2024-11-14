package com.bank.customerOrchestrationService.exception;

public class InvalidAgeException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	String msg1;
	public String getMsg1() {
		return msg1;
	}
	public String getMsg2() {
		return msg2;
	}
	String msg2;
	public InvalidAgeException(String msg,String msg2) {
		this.msg1=msg;
		this.msg2=msg2;
	}
	
	

}
