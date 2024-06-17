package org.ltoscano.accounts.services;

import org.ltoscano.accounts.model.Account;
import org.ltoscano.accounts.model.dto.AccountCreationDTO;
import org.ltoscano.accounts.model.dto.CustomerDTO;
import org.ltoscano.accounts.repository.AccountRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class AccountService {

	private final AccountRepository accountRepository;
	private final RestClient restClient;
	
	
	public AccountService(AccountRepository accountRepository, RestClient.Builder restClientBuilder) {
		this.accountRepository = accountRepository;
		this.restClient = restClientBuilder.baseUrl("http://localhost:8081").build();
	}
	
	public Account createAccount(AccountCreationDTO accountCreationDTO) {
		CustomerDTO customerDTO = accountCreationDTO.customer();
		
		ResponseEntity<CustomerDTO> response = restClient.post()
		  .uri("/clientes")
		  .body(customerDTO)
		  .retrieve()
		  .toEntity(CustomerDTO.class);
		
		Account account = new Account(response.getBody().id());
		account.setType(accountCreationDTO.type());
		
		this.accountRepository.save(account);
		return account;
	}
}
