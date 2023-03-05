package com.raster.exceptions;

public class BookAlreadyExistsException extends RuntimeException {
	private String message;

	public BookAlreadyExistsException() {
		super();
	}

	public BookAlreadyExistsException(String message) {
		super(message);
		this.message = message;
	}
}
