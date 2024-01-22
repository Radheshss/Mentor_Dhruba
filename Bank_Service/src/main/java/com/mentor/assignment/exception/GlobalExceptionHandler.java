package com.mentor.assignment.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
	private static final Logger logger =LoggerFactory.getLogger(GlobalExceptionHandler.class);
@ExceptionHandler(ResourceNotFoundException.class)
public String handleResourceNotFoundException(ResourceNotFoundException ex) {
	logger.error(ex.getMessage());
//	System.out.println(ex.getMessage());
	return ex.getMessage();
}
@ExceptionHandler(DuplicateDataException.class)
public String handleResourceNotFoundException(DuplicateDataException ex) {
	logger.error(ex.getMessage());
//	System.out.println(ex.getMessage());
	return ex.getMessage();
}

}
