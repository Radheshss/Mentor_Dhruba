package com.mentor.assignment.controller;

import java.util.List;

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

import com.mentor.assignment.model.request.Bank;
import com.mentor.assignment.service.BankService;

@RestController
@RequestMapping("/bank")
public class BankController {
	private static final Logger logger = LoggerFactory.getLogger(BankController.class);

	@Autowired
	private BankService service;

	@GetMapping
	@ResponseStatus(value = HttpStatus.FOUND)

//	http://localhost:8085/bank
	public List<Bank> getAllDetails() {
		return service.getAllDetails();
	}

	@GetMapping("{accountNo}")
//	http://localhost:8085/bank/a001
	@ResponseStatus(value = HttpStatus.FOUND)

	public Bank getBankByAccountNo(@PathVariable("accountNo") String accountNo) {
		logger.info("Fetched Bank Data with account number: " + accountNo);

		return service.getBankByAccountNo(accountNo);
	}

	@PostMapping
//http://localhost:8085/bank
	@ResponseStatus(value = HttpStatus.CREATED)

	public String saveBank(@RequestBody Bank bank) {
		logger.info("Saved Bank Data with account number: " + bank.getAccountNo());

		return service.saveBank(bank);
	}

	@PatchMapping("{accountNo}")
	@ResponseStatus(value = HttpStatus.OK)

//http://localhost:8085/bank/a001
	public String updateBank(@RequestBody Bank bank, @PathVariable("accountNo") String accountNo) {
		logger.info("Updated Bank Data with account number: " + accountNo);

		return service.updateBank(bank, accountNo);
	}

	@DeleteMapping("{accountNo}")
	@ResponseStatus(value = HttpStatus.OK)

//http://localhost:8085/bank/a001
	public String deleteBank(@PathVariable("accountNo") String accountNo) {
		logger.info("Deleted Bank Data with account number: " + accountNo);

		return service.deleteBank(accountNo);
	}
}
