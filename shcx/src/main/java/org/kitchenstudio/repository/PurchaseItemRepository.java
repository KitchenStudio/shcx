package org.kitchenstudio.repository;

import org.kitchenstudio.entity.PurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseItemRepository extends
		JpaRepository<PurchaseItem, Long> {

}
