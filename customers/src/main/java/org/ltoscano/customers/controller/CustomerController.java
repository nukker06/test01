package org.ltoscano.customers.controller;

import java.util.List;

import org.ltoscano.customers.handlers.exceptions.CustomerNotFoundException;
import org.ltoscano.customers.model.Customer;
import org.ltoscano.customers.model.dto.CustomerRequest;
import org.ltoscano.customers.repository.CustomerRepository;
import org.ltoscano.customers.services.CustomerService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	private final CustomerRepository repository;
	private final CustomerService customerService;
	
	public CustomerController(CustomerRepository repository, CustomerService customerService) {
		this.repository = repository;
		this.customerService = customerService;
	}
	
	@GetMapping("/clientes")
	List<Customer> getAllCustomers() {
		return repository.findAll();
	}
	
	@PostMapping("/clientes")
	Customer createCustomer(@RequestBody CustomerRequest customerRequest) {
		return customerService.saveCustomer(customerRequest);
	}

	@DeleteMapping("/clientes/{id}")
	void deleteCustomer(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	@GetMapping("/clientes/{id}")
	Customer getCustomer(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(
				() -> new CustomerNotFoundException(id));
	}
}
