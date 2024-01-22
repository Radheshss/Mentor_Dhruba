package com.mentor.assignment.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Loan {
	@Id
	@Column(name="acc_no",length=10,nullable = false)
	private String acc_no;
	@Column(name="loan_no",length=5)
	private String loanNo;
	@Column(name="loan_amount",length=6)
	private int loanAmount;

}
