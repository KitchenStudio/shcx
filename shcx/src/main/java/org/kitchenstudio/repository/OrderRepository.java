package org.kitchenstudio.repository;

import org.kitchenstudio.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
