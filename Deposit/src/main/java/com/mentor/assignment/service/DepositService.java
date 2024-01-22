package com.mentor.assignment.service;

import com.mentor.assignment.model.request.Deposit;

public interface DepositService  {

	Deposit getDepositByAccountNo(String accountNo);

	String saveDeposit(Deposit deposit);

	String updateDeposit(Deposit deposit, String accountNo);

	String deleteDeposit(String accountNo);

}
