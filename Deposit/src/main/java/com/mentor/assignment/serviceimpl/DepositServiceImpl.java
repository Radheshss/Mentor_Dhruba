package com.mentor.assignment.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentor.assignment.exception.DuplicateDataException;
import com.mentor.assignment.model.request.Deposit;
import com.mentor.assignment.repository.DepositRepository;
import com.mentor.assignment.service.DepositService;

@Service
public class DepositServiceImpl implements DepositService {
	@Autowired
	private DepositRepository repository;

	@Override
	public Deposit getDepositByAccountNo(String accountNo) {
		// TODO Auto-generated method stub
		return repository.findByAccountNo(accountNo);
	}

	@Override
	public String saveDeposit(Deposit deposit) {
		// TODO Auto-generated method stub
//		if (repository.findByAccountNo(deposit.getAccountNo()) != null)
//			throw new DuplicateDataException("account number" + "=" + deposit.getAccountNo() + "  already exits");

		try {
			return (repository.saveDeposit(deposit) > 0) ? "Successfully saved" : "Data not saved";
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			throw new DuplicateDataException("account number" + "=" + deposit.getAccountNo() + "  already exits");

		}

	}

	@Override
	public String updateDeposit(Deposit deposit, String accountNo) {
		// TODO Auto-generated method stub
		repository.findByAccountNo(accountNo);
		return (repository.updateDeposit(deposit, accountNo) > 0) ? "Successfully updates" : "something went wrong";
//				: "Account number =" + accountNo + " doesn't exist";
	}

	@Override
	public String deleteDeposit(String accountNo) {
		// TODO Auto-generated method stub
		repository.findByAccountNo(accountNo);
		return (repository.deleteDeposit(accountNo) > 0) ? "Deleted successfully" : "something went wrong";
//				: "Account Number"+"="+accountNo+"doesn't exist";

	}

}
