package org.ltoscano.accounts.handlers.advices;

import org.ltoscano.accounts.handlers.exceptions.InsufficientFundsException;
import org.ltoscano.accounts.model.dto.InsufficientFundsError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class InsufficientFundsAdvice {

	@ExceptionHandler(InsufficientFundsException.class)
	@ResponseBody
	ResponseEntity<InsufficientFundsError> handleInsufficientFundsException(InsufficientFundsException ex) {
		InsufficientFundsError error = new InsufficientFundsError(ex.getMessage());
		return new ResponseEntity<InsufficientFundsError>(error, HttpStatus.BAD_REQUEST);
	}
}
