package com.mentor.assignment.service;

import com.mentor.assignment.model.request.Loan;

public interface LoanService {

	String deleteLoan(String accountNo);

	String updateLoan(Loan loan, String accountNo);

	String saveLoan(Loan loan);

	Loan getByAccountNo(String accountNo);



	

}
