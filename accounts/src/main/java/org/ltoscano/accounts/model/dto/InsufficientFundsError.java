package org.ltoscano.accounts.model.dto;

public class InsufficientFundsError {
	private String message;

	public InsufficientFundsError(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
