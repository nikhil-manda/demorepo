package com.bank.customerOrchestrationService.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(InvalidAgeException.class)
	public ResponseEntity<ErrorMsg> handleExc(InvalidAgeException exc,HttpServletRequest req) {
		
		ErrorMsg e = new ErrorMsg();
		e.setCode("422");
		e.setDetails(exc.getMsg1());
		e.setDetails2(req.getRequestURL().toString());
		e.setTimestamp(LocalDateTime.now());
		e.setUuid("123");
		return new ResponseEntity<ErrorMsg>(e, HttpStatus.UNPROCESSABLE_ENTITY);
	}
}
