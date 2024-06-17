package org.ltoscano.accounts.repository;

import org.ltoscano.accounts.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
