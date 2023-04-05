package com.ptech.user.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ptech.user.service.paylod.CustomeErrorResponse;

@RestControllerAdvice
public class GenericExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<CustomeErrorResponse> handleUserNotFoundExceptio(UserNotFoundException exception){
		return new ResponseEntity<CustomeErrorResponse>(CustomeErrorResponse.builder().message(exception.getMessage()).success(false).httpStatus(HttpStatus.NOT_FOUND).build(),HttpStatus.NOT_FOUND);
	}

}
