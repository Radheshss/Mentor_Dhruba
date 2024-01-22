package com.mentor.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)

public class ExceptionWithLoan extends RuntimeException{
private String message;

public ExceptionWithLoan(String message) {
	super();
	this.message = message;
}

}
