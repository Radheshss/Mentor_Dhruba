package com.mentor.assignment.service;

import java.util.List;

import com.mentor.assignment.model.request.Bank;

public interface BankService {

	List<Bank> getAllDetails();

	Bank getBankByAccountNo(String accountNo);

	String saveBank(Bank bank);

	String updateBank(Bank bank,String accountNo);

	String deleteBank(String accountNo);

}
