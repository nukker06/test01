package org.ltoscano.customers.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.ltoscano.customers.model.Customer;
import org.ltoscano.customers.model.dto.CustomerRequest;
import org.ltoscano.customers.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	private final CustomerRepository customerRepository;
	
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	public Customer saveCustomer(CustomerRequest customerRequest) {
		Customer customer = new Customer(Math.abs(new Random().nextLong()), customerRequest.password(), "ACTIVO");
		customer.setAddress(customerRequest.address());
		customer.setDateOfBirth(customerRequest.dateOfBirth());
		customer.setGenre(customerRequest.genre());
		customer.setName(customerRequest.name());
		customer.setPhone(customerRequest.phone());
		this.customerRepository.save(customer);
		
		return customer;
		
	}
	
	public List<String> validateCustomer(CustomerRequest customerRequest) {
		List<String> errors = new ArrayList<>();
		
		
		return errors;
	}
}
