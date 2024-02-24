package net.javaguides.lms.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@Column(name = "user_name", nullable = false)
	private String userName;
	
	@Column(name = "issue_date")
	private LocalDate issueDate;
	
	@Column(name = "expiry_date")
	private LocalDate expiryDate;
	
	
}