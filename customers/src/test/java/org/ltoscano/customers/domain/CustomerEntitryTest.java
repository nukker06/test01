package org.ltoscano.customers.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.ltoscano.customers.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import jakarta.persistence.EntityManager;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureDataJpa
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureTestEntityManager	
@ContextConfiguration
public class CustomerEntitryTest {

	@Autowired
	protected ApplicationContext context;

	@Autowired
	protected EntityManager em;

	protected JpaTransactionManager transactionManager;

	@BeforeEach
	public void setUp() {
		transactionManager = context.getBean(JpaTransactionManager.class);
	}

	protected TransactionStatus getTransactionStatus() {
		return transactionManager
				.getTransaction(new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRES_NEW));
	}

	@Test
	public void whenACustomerIsCreated_thenCustomerShouldHaveId() {
		// given
		TransactionStatus transaction = getTransactionStatus();

		// When
		Customer customer = new Customer();
		customer.setName("John Doe");
		em.persist(customer);
		
		// Then validate the new entity was created
		assertThat(customer.getName()).isNotNull();
		assertThat(customer.getId()).isNotNull();
		transactionManager.commit(transaction);

	}
	
	

}
