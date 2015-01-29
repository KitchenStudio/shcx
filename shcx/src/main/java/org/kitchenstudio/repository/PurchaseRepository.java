package org.kitchenstudio.repository;

import org.kitchenstudio.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long>{

}
