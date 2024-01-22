package com.mentor.assignment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mentor.assignment.exception.GlobalExceptionHandler;
import com.mentor.assignment.model.request.Loan;
import com.mentor.assignment.service.LoanService;

@RestController
@RequestMapping("/loan")
public class LoanController {
	private static final Logger logger =LoggerFactory.getLogger(LoanController.class);

	@Autowired
	private LoanService service;

	@GetMapping("{accountNo}")
	@ResponseStatus(value = HttpStatus.FOUND)
	public Loan getByAccountNo(@PathVariable("accountNo") String accountNo) {
		logger.info("Fetched Loan Data with account number: "+accountNo);
		return service.getByAccountNo(accountNo);
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public String saveLoan(@RequestBody Loan loan) {
		logger.info("Saved Loan Data of account number: "+loan.getAcc_no());

		return service.saveLoan(loan);

	}

	@PatchMapping("{accountNo}")
	@ResponseStatus(value = HttpStatus.OK)
	public String updateLoan(@RequestBody Loan loan, @PathVariable("accountNo") String accountNo) {
		logger.info("Updated Loan Data of account number: "+accountNo);

		return service.updateLoan(loan, accountNo);
	}

	@DeleteMapping("{accountNo}")
	@ResponseStatus(value = HttpStatus.OK)
	public String deleteLoan(@PathVariable("accountNo") String accountNo) {
		logger.info("Deleted Loan Data of account number: "+accountNo);

		return service.deleteLoan(accountNo);
	}

}
