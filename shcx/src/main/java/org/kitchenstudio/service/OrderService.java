package org.kitchenstudio.service;

import java.util.List;

import org.kitchenstudio.entity.Order;
import org.kitchenstudio.entity.OrderItem;

public interface OrderService {
	List<Order> findAll();
	void add(Order order);
	void delete(Order order);
	void save(Order order,List<OrderItem> orderitems);
	
}
