package org.kitchenstudio.repository;

import org.kitchenstudio.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Long>{

}
