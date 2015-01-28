package org.kitchenstudio.service;

import java.util.List;
import org.kitchenstudio.model.Order;

public interface OrderService {
	List<Order> findAll();
	void add(Order order);
	void delete(Order order);
	
}
