package com.mentor.assignment.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "deposit")
public class Deposit {
	@Id
	@Column(name = "acc_no", length = 10, nullable = false)
	private String accountNo;
	@Column(name = "deposit_no", length = 5)
	private String depositNo;
	@Column(name = "deposit_amount", length = 6)
	private int depositAmount;

}
