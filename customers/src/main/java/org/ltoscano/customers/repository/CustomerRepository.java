package org.ltoscano.customers.repository;

import org.ltoscano.customers.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
