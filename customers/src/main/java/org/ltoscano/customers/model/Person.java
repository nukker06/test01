package org.ltoscano.customers.model;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Person {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private String genre;
	@Column(name = "date_birth")
	private LocalDate dateOfBirth;
	private String address;
	private String phone;
	
	public Person() {
	}
	
	public Person(String name, String genre, LocalDate dateOfBirth, String address, String phone) {
		super();
		this.name = name;
		this.genre = genre;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.phone = phone;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, dateOfBirth, genre, id, name, phone);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(address, other.address) && Objects.equals(dateOfBirth, other.dateOfBirth)
				&& Objects.equals(genre, other.genre) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(phone, other.phone);
	}
	@Override
	public String toString() {
		return String.format("Person [id=%s, name=%s, genre=%s, dateOfBirth=%s, address=%s, phone=%s]", id, name, genre,
				dateOfBirth, address, phone);
	}
	
	
}
