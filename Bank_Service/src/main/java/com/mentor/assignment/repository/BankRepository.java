package com.mentor.assignment.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mentor.assignment.exception.ResourceNotFoundException;
import com.mentor.assignment.model.request.Bank;

@Repository
public class BankRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Bank> findAll() {
		String sqlFindAll = "select * from bank_customer";
//		return jdbcTemplate.query(sqlFindAll, (rs, rowNum) -> {
//			Bank bank = new Bank();
//			bank.setAccountNo(rs.getString("acc_no"));
//			bank.setCustomerName(rs.getString("cust_name"));
//			bank.setPlace(rs.getString("place"));
//			return bank;
//		});
		 return jdbcTemplate.query(sqlFindAll, mapToBank());
	}

	public Bank findByAccountNo(String accountNo) {
		try {
			String sqlFindByAccountNo = "SELECT * FROM bank_customer WHERE acc_no = ?";
			return jdbcTemplate.queryForObject(sqlFindByAccountNo, mapToBank(),  accountNo );
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			throw new ResourceNotFoundException("Account number " + accountNo + " doesn't exist");

		}
	}
	
	  private RowMapper<Bank> mapToBank() {
	        return (rs, rowNum) -> {
	            Bank bank = new Bank();
	            bank.setAccountNo(rs.getString("acc_no"));
	            bank.setCustomerName(rs.getString("cust_name"));
	            bank.setPlace(rs.getString("place"));
	            return bank;
	        };
	    }

	public int saveBank(Bank bank) {
String sqlSave="insert into bank_customer (acc_no,cust_name,place) value(?,?,?)";
		return jdbcTemplate.update(sqlSave,bank.getAccountNo(),bank.getCustomerName(),bank.getPlace());
	}

	public int updateBank(Bank bank,String accountNo) {
		String sqlUpdate="update bank_customer set cust_name=?,place=? where acc_no=?";
		return jdbcTemplate.update(sqlUpdate,bank.getCustomerName(),bank.getPlace(),accountNo);
	}

	public int deleteBank(String accountNo) {
		String sqlDelete="delete from bank_customer WHERE acc_no = ?";
		return jdbcTemplate.update(sqlDelete,accountNo);
	}
	

//	public void save(Alien alien) {
//		String sql = "insert into alien (id, name , tech) values (?,?,?)";
//   		System.out.println(template.update(sql, alien.getId(), alien.getName(), alien.getTech()) + "row/s effected");
//	}
//
//	public List<Alien> findAll() {
//		String sql = "select * from alien";
//		return template.query(sql, (rs, row) -> {
//			Alien a = new Alien();
//			a.setId(rs.getInt(1));
//			a.setName(rs.getString(2));
//			a.setTech(rs.getString(3));
//			return a;
//		});

}
