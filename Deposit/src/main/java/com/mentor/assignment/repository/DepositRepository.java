package com.mentor.assignment.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mentor.assignment.exception.ResourseNotFoundException;
import com.mentor.assignment.model.request.Deposit;

@Repository
public class DepositRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Deposit findByAccountNo(String accountNo) {
		try {
			String sqlFindByAccountNo = "SELECT * FROM deposit WHERE acc_no = ?";
			return jdbcTemplate.queryForObject(sqlFindByAccountNo, mapToDeposit(), accountNo);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			throw new ResourseNotFoundException("Account number =" + accountNo + " doesn't exist");
		}
	}

	private RowMapper<Deposit> mapToDeposit() {
		return (rs, rowNum) -> {
			Deposit deposit = new Deposit();
			deposit.setAccountNo(rs.getString("acc_no"));
			deposit.setDepositNo(rs.getString("deposit_no"));
			deposit.setDepositAmount(rs.getInt("deposit_amount"));
			return deposit;
		};
	}

	public int saveDeposit(Deposit deposit) {
		String sqlSave = "insert into deposit (acc_no,deposit_no,deposit_amount) value(?,?,?)";
		return jdbcTemplate.update(sqlSave, deposit.getAccountNo(), deposit.getDepositNo(), deposit.getDepositAmount());
	}

	public int updateDeposit(Deposit deposit, String accountNo) {
		String sqlUpdate = "update deposit set deposit_no=?,deposit_amount=? where acc_no=?";
		return jdbcTemplate.update(sqlUpdate, deposit.getDepositNo(), deposit.getDepositAmount(), accountNo);
	}

	public int deleteDeposit(String accountNo) {
		String sqlDelete = "delete from deposit WHERE acc_no = ?";
		return jdbcTemplate.update(sqlDelete, accountNo);
	}
}
