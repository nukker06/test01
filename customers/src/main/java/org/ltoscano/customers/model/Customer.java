package org.ltoscano.customers.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Customer extends Person {
	
	@Column(name = "customer_id", updatable = false, unique = true)
	private Long customerId;
	@JsonIgnore
	private String password;
	private String status;
	
	public Customer() {
	}
	
	public Customer(Long customerId, String password, String status) {
		super();
		this.customerId = customerId;
		this.password = password;
		this.status = status;
	}

	public Long getCustomerId() {
		return customerId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
