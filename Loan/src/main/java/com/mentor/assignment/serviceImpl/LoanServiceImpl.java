package com.mentor.assignment.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentor.assignment.exception.DuplicateDataException;
import com.mentor.assignment.model.request.Loan;
import com.mentor.assignment.repository.LoanRepository;
import com.mentor.assignment.service.LoanService;

@Service
public class LoanServiceImpl implements LoanService {
	@Autowired
	private LoanRepository repository;

	@Override
	public String deleteLoan(String accountNo) {
		// TODO Auto-generated method stub
		repository.findByAccountNo(accountNo) ;
			return	 (repository.deleteLoan(accountNo) > 0) ? "Deleted Successfully"
						: "Something went wrong while deleting";
	}

	@Override
	public String updateLoan(Loan loan, String accountNo) {
		// TODO Auto-generated method stub
		repository.findByAccountNo(accountNo) ;
				return (repository.updateLoan(loan, accountNo) > 0) ? "Successfully updated"
						: "something went wrong while updating";
//				: "Accoount number =" + accountNo + " doesn't exist";
	}

	@Override
	public String saveLoan(Loan loan) {
		// TODO Auto-generated method stub
//		return (repository.findByAccountNo(loan.getAcc_no()) == null)
				try {
					return repository.saveLoan(loan) > 0 ? "successfully saved" : "Data not saved";
				} catch (Exception e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
					throw new DuplicateDataException("account number= " + loan.getAcc_no() + " already exits");
				}
//				: "account number= " + loan.getAcc_no() + " already exits";
	}

	@Override
	public Loan getByAccountNo(String accountNo) {
		// TODO Auto-generated method stub
		return repository.findByAccountNo(accountNo);
	}

}
