package com.mentor.assignment.model;

public class AllDetails {
private String accountNo;
private Bank bank;
private Deposit deposit;
private Loan loan;
public AllDetails(String accountNo,Bank bank, Deposit deposit, Loan loan) {
	super();
	this.accountNo=accountNo;
	this.bank = bank;
	this.deposit = deposit;
	this.loan = loan;
}
public Bank getBank() {
	return bank;
}
public void setBank(Bank bank) {
	this.bank = bank;
}
public Deposit getDeposit() {
	return deposit;
}
public void setDeposit(Deposit deposit) {
	this.deposit = deposit;
}
public Loan getLoan() {
	return loan;
}
public void setLoan(Loan loan) {
	this.loan = loan;
}
public String getAccountNo() {
	return accountNo;
}
public void setAccountNo(String accountNo) {
	this.accountNo = accountNo;
}
	
	
	
}
