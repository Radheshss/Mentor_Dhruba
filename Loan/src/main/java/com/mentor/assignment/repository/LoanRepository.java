package com.mentor.assignment.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mentor.assignment.exception.DuplicateDataException;
import com.mentor.assignment.exception.ResourceNotFoundException;
import com.mentor.assignment.model.request.Loan;

@Repository
public class LoanRepository {
@Autowired
private JdbcTemplate jdbcTemplate;
	
	
	
	public int deleteLoan(String accountNo) {
		String sqlDelete="delete from loan WHERE acc_no = ?";

		return jdbcTemplate.update(sqlDelete,accountNo);
	}


	public int updateLoan(Loan loan, String accountNo) {
		String sqlUpdate="update loan set loan_no=?,loan_amount=? where acc_no=?";
		return jdbcTemplate.update(sqlUpdate,loan.getLoanNo(),loan.getLoanAmount(),accountNo);
	}


	public int saveLoan(Loan loan) {
		String sqlSave="insert into loan (acc_no,loan_no,loan_amount) value(?,?,?)";
		return jdbcTemplate.update(sqlSave,loan.getAcc_no(),loan.getLoanNo(),loan.getLoanAmount());
	}


	public Loan findByAccountNo(String accountNo) {
		try {
			String sqlFindByAccountNo = "SELECT * FROM loan WHERE acc_no = ?";
			return jdbcTemplate.queryForObject(sqlFindByAccountNo, mapToLoan(),accountNo);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			throw new ResourceNotFoundException("Account number =" + accountNo + " doesn't exit");
		}
	}
	private RowMapper<Loan> mapToLoan(){
		return (rs,rowNum)->{
			Loan loan =new Loan();
		loan.setAcc_no(rs.getString("acc_no"));
		loan.setLoanAmount(rs.getInt("loan_amount"));
		loan.setLoanNo(rs.getString("loan_no"));
		return loan;
		};
	}
	

}
