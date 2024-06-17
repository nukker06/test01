package org.ltoscano.accounts.controller;

import java.util.List;

import org.ltoscano.accounts.handlers.exceptions.AccountNotFoundException;
import org.ltoscano.accounts.model.Account;
import org.ltoscano.accounts.model.dto.AccountCreationDTO;
import org.ltoscano.accounts.repository.AccountRepository;
import org.ltoscano.accounts.services.AccountService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
	
	private final AccountRepository repository;
	private final AccountService accountService;
	
	public AccountController(AccountRepository repository, AccountService accountService) {
		this.repository = repository;
		this.accountService = accountService;
	}
	
	@GetMapping("/cuentas")
	List<Account> getAllAccounts() {
		return repository.findAll();
	}
	
	@PostMapping("/cuentas")
	Account createAccount(@RequestBody AccountCreationDTO accountCreationDTO) {
		return accountService.createAccount(accountCreationDTO);
	}

	@DeleteMapping("/cuentas/{id}")
	void deleteAccount(@PathVariable Long id) {
		repository.deleteById(id);
	}

	@GetMapping("/cuentas/{id}")
	Account getAccount(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(
				() -> new AccountNotFoundException(id));
	}
}
