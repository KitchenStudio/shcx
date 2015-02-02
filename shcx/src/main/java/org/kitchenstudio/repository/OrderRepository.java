package org.kitchenstudio.repository;

import org.kitchenstudio.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
