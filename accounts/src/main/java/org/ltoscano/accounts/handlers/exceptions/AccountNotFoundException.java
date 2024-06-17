package org.ltoscano.accounts.handlers.exceptions;

public class AccountNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public AccountNotFoundException(Long number) {
		super("Could not find account " + number);
	}

}
