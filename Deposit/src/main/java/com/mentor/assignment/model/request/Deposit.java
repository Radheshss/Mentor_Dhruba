package com.mentor.assignment.model.request;

public class Deposit {
	private String accountNo;
	private String depositNo;
	private int depositAmount;

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accoundNo) {
		this.accountNo = accoundNo;
	}

	public String getDepositNo() {
		return depositNo;
	}

	public void setDepositNo(String depositNo) {
		this.depositNo = depositNo;
	}

	public int getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(int depositAmount) {
		this.depositAmount = depositAmount;
	}

}
