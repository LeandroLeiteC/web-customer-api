package com.qintess.webapi.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.qintess.webapi.exception.CustomerNotFoundException;
import com.qintess.webapi.exception.CustomerResponseError;

@RestControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler
	public ResponseEntity<CustomerResponseError> handleException(CustomerNotFoundException exc){
		
		CustomerResponseError error = new CustomerResponseError();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
		
		return new ResponseEntity<CustomerResponseError>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomerResponseError> handleException(Exception exc){
		
		CustomerResponseError error = new CustomerResponseError();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
		
		return new ResponseEntity<CustomerResponseError>(error, HttpStatus.BAD_REQUEST);
	}
}
