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
@ExceptionHandler(ExceptionWithBank.class)
public String handleResourceNotFoundException(ExceptionWithBank ex) {
	logger.error(ex.getMessage());
//	System.out.println(ex.getMessage());
	return ex.getMessage();
}
@ExceptionHandler(ExceptionWithLoan.class)
public String handleResourceNotFoundException(ExceptionWithLoan ex) {
	logger.error(ex.getMessage());
//	System.out.println(ex.getMessage());
	return ex.getMessage();
}
@ExceptionHandler(ExceptionWithDeposit.class)
public String handleResourceNotFoundException(ExceptionWithDeposit ex) {
	logger.error(ex.getMessage());
//	System.out.println(ex.getMessage());
	return ex.getMessage();
}
}
