package org.ltoscano.accounts.controller;

import java.time.LocalDate;
import java.util.List;

import org.ltoscano.accounts.handlers.exceptions.MovementNotFoundException;
import org.ltoscano.accounts.model.Movement;
import org.ltoscano.accounts.model.dto.MovementDTO;
import org.ltoscano.accounts.model.dto.SummaryMovementDTO;
import org.ltoscano.accounts.repository.MovementRepository;
import org.ltoscano.accounts.services.MovementService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovementController {

	private final MovementRepository repository;
	private final MovementService service;

	public MovementController(MovementRepository repository, MovementService service) {
		this.repository = repository;
		this.service = service;
	}

	@GetMapping("/movimientos")
	List<Movement> getAllMovements() {
		return repository.findAll();
	}

	@PostMapping("/movimientos")
	Movement createMovement(@RequestBody MovementDTO movementDTO) {
		return service.registerMovement(movementDTO);
	}

	@DeleteMapping("/movimientos/{id}")
	void deleteMovement(@PathVariable Long id) {
		repository.deleteById(id);
	}

	@GetMapping("/movimientos/{id}")
	Movement getMovement(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new MovementNotFoundException(id));
	}

	@GetMapping("/reportes")
	List<SummaryMovementDTO> getMovementsReportByClient(@RequestParam("fechaInicio") LocalDate startDate,
			@RequestParam("fechaFin") LocalDate endDate, @RequestParam("cuenta") long accountNumber) {
		return service.movementsReport(startDate, endDate, accountNumber);
	}

}
