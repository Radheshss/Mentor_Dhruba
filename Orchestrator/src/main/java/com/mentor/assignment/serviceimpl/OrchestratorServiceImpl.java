package com.mentor.assignment.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentor.assignment.model.AllDetails;
import com.mentor.assignment.model.Bank;
import com.mentor.assignment.repository.OrchestratorRepository;
import com.mentor.assignment.service.OrchestratorService;

import reactor.core.publisher.Mono;

@Service
public class OrchestratorServiceImpl implements OrchestratorService{
@Autowired
private OrchestratorRepository repository;
@Override
public Mono<Bank> getBankByAccountNo(String accountNo){
	return repository.getBankByAccountNo(accountNo);
	
}
@Override
public Mono<AllDetails> getAllDetails(String accountNo) {
	// TODO Auto-generated method stub
	return repository.getAllDetails(accountNo);
}

}
