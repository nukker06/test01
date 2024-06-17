package org.ltoscano.accounts.handlers.exceptions;

public class InsufficientFundsException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public InsufficientFundsException(Long id) {
		super("Saldo no disponible");
	}

}
