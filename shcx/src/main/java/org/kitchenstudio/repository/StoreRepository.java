package org.kitchenstudio.repository;

import org.kitchenstudio.entity.Store;
import org.kitchenstudio.entity.StoreType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, StoreType> {

}
