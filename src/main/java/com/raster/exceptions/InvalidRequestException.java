package com.raster.exceptions;

public class InvalidRequestException extends RuntimeException {
	private String message;

	public InvalidRequestException() {
		super();
	}

	public InvalidRequestException(String message) {
		super(message);
		this.message = message;
	}
}
