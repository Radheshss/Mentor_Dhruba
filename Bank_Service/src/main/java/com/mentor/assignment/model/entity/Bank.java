package com.mentor.assignment.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bank_customer")
public class Bank {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
	@Column(name = "acc_no",length=10, nullable = false)
	private String accountNo;
	@Column(name = "cust_name",length=10)
	private String customerName;
	@Column(name = "place", length=15)
	private String place;

}
