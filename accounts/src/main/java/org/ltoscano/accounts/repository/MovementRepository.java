package org.ltoscano.accounts.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.ltoscano.accounts.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovementRepository extends JpaRepository<Movement, Long>{
	
	@Query(value = "select a.number, a.type, b.balance, b.amount, (b.balance + b.amount) current_balance, TO_CHAR(b.processed, 'DD/MM/YYYY') as movement_date\r\n"
			+ " from account a join movement b \r\n"
			+ " on a.number = b.number\r\n"
			+ " where a.customer_id = ?1\r\n"
			+ " and b.processed between ?2 and ?3\r\n"
			+ "	order by b.processed", nativeQuery = true)
	List<Map<String, Object>> reportMovement(long customerId, LocalDate startDate, LocalDate endDate);

}
