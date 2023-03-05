package com.raster.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.ErrorResponseException;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value=BookNotFoundException.class)
	public ResponseEntity<ErrorResponseException> handleBookNotFoundException(BookNotFoundException ex){
		ErrorResponseException error = new ErrorResponseException(HttpStatus.NOT_FOUND);
		error.setDetail(ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=BookAlreadyExistsException.class)
	public ResponseEntity<ErrorResponseException> handleBookAlreadyExistsException(BookAlreadyExistsException ex){
		ErrorResponseException error = new ErrorResponseException(HttpStatus.BAD_REQUEST);
		error.setDetail(ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value=InvalidRequestException.class)
	public ResponseEntity<ErrorResponseException> handleInvalidRequestException(InvalidRequestException ex){
		ErrorResponseException error = new ErrorResponseException(HttpStatus.BAD_REQUEST);
		error.setDetail(ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
