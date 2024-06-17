package org.ltoscano.accounts.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Movement {
	
	@Id
	@GeneratedValue
	private Long movementId;
	@Column(updatable = false)
	private String type;
	@Column(updatable = false)
	private double amount;
	@Column(updatable = false)
	private double balance;
	@Column(updatable = false)
	private LocalDateTime processed;
	@ManyToOne
	@JoinColumn(name="number")
	private Account account;
	
	public Movement() {
	}
	
	public Movement(double amount, double balance, Account account) {
		super();
		this.amount = amount;
		this.balance = balance;
		this.account = account;
		this.processed = LocalDateTime.now();
		this.type = amount > 0 ? "Deposit" : "Withdrawal";
	}

	public Long getMovementId() {
		return movementId;
	}
	public void setMovementId(Long movementId) {
		this.movementId = movementId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}

}
