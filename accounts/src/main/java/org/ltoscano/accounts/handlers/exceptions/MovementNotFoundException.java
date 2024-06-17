package org.ltoscano.accounts.handlers.exceptions;

public class MovementNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public MovementNotFoundException(Long id) {
		super("Could not find movement " + id);
	}

}
