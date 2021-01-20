package com.example.resources.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.exception.NotFoundException;

@ControllerAdvice
public class HandlerError {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Error> notFound(NotFoundException ex){
		Error e = new Error(HttpStatus.NOT_FOUND.value(), ex.getMessage(), new Date());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
	} 
}