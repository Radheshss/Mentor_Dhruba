package com.mentor.assignment.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import com.mentor.assignment.exception.ExceptionWithLoan;
import com.mentor.assignment.model.AllDetails;
import com.mentor.assignment.model.Bank;
import com.mentor.assignment.model.Deposit;
import com.mentor.assignment.model.Loan;

import reactor.core.publisher.Mono;

@Repository   
public class OrchestratorRepository {


private final WebClient BankClient=WebClient.create("http://localhost:8085/bank");
private final WebClient DepositClient=WebClient.create("http://localhost:8086/deposit");
private final WebClient LoanClient=WebClient.create("http://localhost:8087/loan");

	
	
public Mono<Bank> getBankByAccountNo(String accountNo){
	
	Mono<Bank> BankMono = BankClient.get()
			  .uri("/{accountNo}", accountNo)
			  .retrieve()
			  .bodyToMono(Bank.class)
			  .onErrorResume(error -> {
                  System.err.println("Error fetching bank details: " + error.getMessage());
                  return Mono.just(new Bank()); 
              });

			return BankMono;
}
public Mono<Deposit> getDepositByAccountNo(String accountNo){
	
	Mono<Deposit> DepositMono = DepositClient.get()
			  .uri("/{accountNo}", accountNo)
			  .retrieve()
			  .bodyToMono(Deposit.class)
			  .onErrorResume(error -> {
                  System.err.println("Error fetching deposit details: " + error.getMessage());
                  return Mono.just(new Deposit()); 
              });

			return DepositMono;
}
public Mono<Loan> getLoanByAccountNo(String accountNo){
	
	Mono<Loan> LoanMono = LoanClient.get()
			  .uri("/{accountNo}", accountNo)
			  .retrieve()
			  .bodyToMono(Loan.class)
			  .onErrorResume(error -> {
                  System.err.println("Error fetching loan details: " + error.getMessage());
                  return Mono.just(new Loan()); 
              });;

			return LoanMono;
}

public Mono<AllDetails> getAllDetails(String accountNo) {
	 Mono<Bank> bankMono = getBankByAccountNo(accountNo);
     Mono<Deposit> depositMono = getDepositByAccountNo(accountNo);
     Mono<Loan> loanMono = getLoanByAccountNo(accountNo);
//     Used Mono.zip to combine multiple Monos into one.
//     Used map to transform the tuple into an AllDetails object.
//     The Mono.zip operator combines these three Monos into a new Mono that emits a tuple containing the results of the individual Monos.
     return Mono.zip(bankMono, depositMono, loanMono)
             .map(tuple -> new AllDetails(accountNo,tuple.getT1(), tuple.getT2(), tuple.getT3()));
}


	
	
}
