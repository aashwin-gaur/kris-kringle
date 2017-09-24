package com.kriskringle.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {

	@ExceptionHandler(InvalidDateException.class)
	public ResponseEntity<KrisKringleException.ExceptionResponseObject> handleException(InvalidDateException e) {
		return ResponseEntity
				.status(HttpStatus.NOT_ACCEPTABLE)
				.body(e.getResponse());
	}
}
