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

import com.mentor.assignment.model.request.Deposit;
import com.mentor.assignment.service.DepositService;

@RestController
@RequestMapping("/deposit")
public class DepositController {
	private static final Logger logger =LoggerFactory.getLogger(DepositController.class);

	@Autowired
	private DepositService service;

	@GetMapping("{accountNo}")
//http://localhost:8085/bank/a001
	@ResponseStatus(value = HttpStatus.FOUND)

	public Deposit getDepositByAccountNo(@PathVariable("accountNo") String accountNo) {
		logger.info("Fetched Deposit Data with account number: "+accountNo);

		return service.getDepositByAccountNo(accountNo);
	}

	@PostMapping
//http://localhost:8086/deposit
	@ResponseStatus(value = HttpStatus.CREATED)

	public String saveDeposit(@RequestBody Deposit deposit) {
		logger.info("Saved Loan Data of account number: "+deposit.getAccountNo());

		return service.saveDeposit(deposit);
	}

	@PatchMapping("{accountNo}")
//http://localhost:8086/deposit/a001
	@ResponseStatus(value = HttpStatus.OK)

	public String updateDeposit(@RequestBody Deposit deposit, @PathVariable("accountNo") String accountNo) {
		
		logger.info("Updated Deposit Data of account number: "+accountNo);
return service.updateDeposit(deposit, accountNo);
	}

	@DeleteMapping("{accountNo}")
	@ResponseStatus(value = HttpStatus.OK)

//http://localhost:8086/deposit/a001
	public String deleteDeposit(@PathVariable("accountNo") String accountNo) {
		logger.info("Deleted Deposit Data of account number: "+accountNo);

		return service.deleteDeposit(accountNo);
	}
}
