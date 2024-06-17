package org.ltoscano.accounts.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Account {
	
	@Id
	@GeneratedValue
	private Long number;
	@Column(updatable = false)
	private String type;
	private double balance;
	private String status;
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	private List<Movement> movements;
	@Column(updatable = false, name = "customer_id")
	@JsonIgnore
	private Long customerId;
	
	public Account() {
	}
	
	public Account(Long customerId) {
		this.balance = 10; // minimum deposit
		this.customerId = customerId;
		this.status = "ACTIVA";
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Movement> getMovements() {
		return movements;
	}

	public void setMovements(List<Movement> movements) {
		this.movements = movements;
	}

	public Long getCustomerId() {
		return customerId;
	}
	

}
