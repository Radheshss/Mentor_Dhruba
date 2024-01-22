package com.mentor.assignment.service;

import com.mentor.assignment.model.AllDetails;
import com.mentor.assignment.model.Bank;

import reactor.core.publisher.Mono;

public interface OrchestratorService {

	Mono<Bank> getBankByAccountNo(String accountNo);

	Mono<AllDetails> getAllDetails(String accountNo);

}
