package com.example.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
@ControllerAdvice
public class CustomerExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleCustomerNotFoundException(CustomerNotFoundException exp){
		CustomerErrorResponse error = new CustomerErrorResponse();
		
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setErrorMsg(exp.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception exp){
		CustomerErrorResponse error = new CustomerErrorResponse();
		
		error.setStatusCode(HttpStatus.BAD_REQUEST.value());
		error.setErrorMsg(exp.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
