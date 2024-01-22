package com.mentor.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mentor.assignment.model.AllDetails;
import com.mentor.assignment.service.OrchestratorService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orchestrator")
public class OrchestratorController {

	@Autowired
	private OrchestratorService service;
//	@GetMapping("{accountNo}")
//	public Mono<Bank> getBankByAccountNo(@PathVariable("accountNo") String accountNo){
//		return service.getBankByAccountNo(accountNo);
//		
//	}

	@GetMapping("{accountNo}")
	@ResponseStatus(value = HttpStatus.FOUND)
	public Mono<AllDetails> getAllDetails(@PathVariable("accountNo") String accountNo) {
		return service.getAllDetails(accountNo);

	}

}
