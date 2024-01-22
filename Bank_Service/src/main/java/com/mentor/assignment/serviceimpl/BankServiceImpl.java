package com.mentor.assignment.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentor.assignment.exception.DuplicateDataException;
import com.mentor.assignment.model.request.Bank;
import com.mentor.assignment.repository.BankRepository;
import com.mentor.assignment.service.BankService;

@Service
public class BankServiceImpl implements BankService {
	@Autowired
	private BankRepository repository;

	@Override
	public List<Bank> getAllDetails() {
		return repository.findAll();
	}

	@Override
	public Bank getBankByAccountNo(String accountNo) {
		// TODO Auto-generated method stub
		return repository.findByAccountNo(accountNo);
	}

	@Override
	public String saveBank(Bank bank) {
		// TODO Auto-generated method stub
//		int rows = repository.saveBank(bank);
//		repository.findByAccountNo(bank.getAccountNo());
//		return (repository.saveBank(bank)> 0) ? " successfully Saved" : "Data not saved";
//		if (repository.findByAccountNo(bank.getAccountNo()) != null)
//			throw new DuplicateDataException("Account number " + bank.getAccountNo() + " already exist");
		try {
			return (repository.saveBank(bank) > 0) ? " successfully Saved" : "Data not saved";
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			throw new DuplicateDataException("Account number " + bank.getAccountNo() + " already exist");

		}

	}

	@Override
	public String updateBank(Bank bank, String accountNo) {
//		Optional<Bank> result = repository.findByAccountNo(accountNo);
//		int rows=  repository.updateBank(bank, accountNo);
		repository.findByAccountNo(accountNo);
		return (repository.updateBank(bank, accountNo) > 0) ? " successfully updated"
				: "Something went wrnog while updating";
	}

	@Override
	public String deleteBank(String accountNo) {
//		int rows = ;
		repository.findByAccountNo(accountNo);
		return (repository.deleteBank(accountNo) > 0) ? " Deleted successfully" : "Something went wrnog while deleting";
	}

}
