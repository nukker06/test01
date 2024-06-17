package org.ltoscano.accounts.model.dto;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

public class SummaryMovementDTO {

	private String movementDate;
	private String customer;
	private Long accountNumber;
	private String accountType;
	private double initialBalance;
	private boolean status;
	private double movementAmount;
	private double currentBalance;

	public SummaryMovementDTO(Map<String, Object> row, String customer) {
		if (Objects.isNull(row)) {
			throw new IllegalArgumentException("Row cant be null");
		}
		
		this.movementDate = (String) row.get("movement_date");
		this.customer = customer;
		this.accountNumber = (Long) row.get("number");
		this.accountType = (String) row.get("type");
		this.initialBalance = (double) row.get("balance");
		this.status = true;
		this.movementAmount = (double) row.get("amount");
		this.currentBalance = (double) row.get("current_balance");
	}

	public String getMovementDate() {
		return movementDate;
	}

	public String getCustomer() {
		return customer;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public double getInitialBalance() {
		return initialBalance;
	}

	public boolean isStatus() {
		return status;
	}

	public double getMovementAmount() {
		return movementAmount;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

}
