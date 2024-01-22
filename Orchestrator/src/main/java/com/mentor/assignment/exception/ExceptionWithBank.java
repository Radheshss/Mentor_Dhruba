package com.mentor.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)

public class ExceptionWithBank extends RuntimeException{
	private String message;

	public ExceptionWithBank(String message) {
		super();
		this.message = message;
	}
}
