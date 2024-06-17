package org.ltoscano.accounts.model.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CustomerDTO(String name, String genre, LocalDate dateOfBirth, String address, String phone,
		String password, Long id) {
}
