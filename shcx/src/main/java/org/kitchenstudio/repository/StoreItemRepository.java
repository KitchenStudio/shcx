package org.kitchenstudio.repository;

import org.kitchenstudio.entity.StoreItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreItemRepository extends JpaRepository<StoreItem, Long> {

}
