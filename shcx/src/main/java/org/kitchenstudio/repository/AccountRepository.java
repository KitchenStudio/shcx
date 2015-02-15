package org.kitchenstudio.repository;

import org.kitchenstudio.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {

}
