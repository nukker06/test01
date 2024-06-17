package org.ltoscano.accounts.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.ltoscano.accounts.handlers.exceptions.AccountNotFoundException;
import org.ltoscano.accounts.handlers.exceptions.InsufficientFundsException;
import org.ltoscano.accounts.model.Account;
import org.ltoscano.accounts.model.Movement;
import org.ltoscano.accounts.model.dto.CustomerDTO;
import org.ltoscano.accounts.model.dto.MovementDTO;
import org.ltoscano.accounts.model.dto.SummaryMovementDTO;
import org.ltoscano.accounts.repository.AccountRepository;
import org.ltoscano.accounts.repository.MovementRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class MovementService {
	
	private final MovementRepository repository;
	private final AccountRepository accountRepository;
	private final RestClient restClient;
	
	public MovementService(MovementRepository repository, AccountRepository accountRepository, RestClient.Builder restClientBuilder) {
		this.repository = repository;
		this.accountRepository = accountRepository;
		this.restClient = restClientBuilder.baseUrl("http://localhost:8081").build();
	}

	public Movement registerMovement(MovementDTO movementDTO) {
		Account account = this.accountRepository.findById(movementDTO.accountNumber()).orElseThrow(
				() -> new AccountNotFoundException(movementDTO.accountNumber()));
		double balance = account.getBalance();
		double newBalance = balance + movementDTO.amount();
		
		if (newBalance < 0 ) {
			throw new InsufficientFundsException(movementDTO.accountNumber());
		}
		Movement movement = new Movement(movementDTO.amount(), balance, account);		
		this.repository.save(movement);
		account.setBalance(newBalance);
		this.accountRepository.save(account);
		
		return movement;
	}
	
	public List<SummaryMovementDTO> movementsReport(LocalDate startDate, LocalDate endDate, long accountNumber) {
		Account account = this.accountRepository.findById(accountNumber).orElseThrow(
				() -> new AccountNotFoundException(accountNumber));
		
		ResponseEntity<CustomerDTO> response = restClient.get()
				  .uri("/clientes/"+account.getCustomerId())
				  .retrieve()
				  .toEntity(CustomerDTO.class);
		String customerName = response.getBody().name();
		
		List<Map<String, Object>> result = repository.reportMovement(response.getBody().id(), startDate, endDate);
		List<SummaryMovementDTO> movements = new ArrayList<>();
		for (Map<String, Object> row: result) {
			SummaryMovementDTO movement = new SummaryMovementDTO(row, customerName);
			movements.add(movement);
		}
		return movements;
	}
	
}
