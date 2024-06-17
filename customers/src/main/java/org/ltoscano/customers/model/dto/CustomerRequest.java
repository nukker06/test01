package org.ltoscano.customers.model.dto;

import java.time.LocalDate;

public record CustomerRequest(String name, String genre, LocalDate dateOfBirth, String address, String phone,
		String password) {
}
