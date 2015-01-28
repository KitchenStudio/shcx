package org.kitchenstudio.service;

import java.util.List;

import org.kitchenstudio.model.Order;
import org.kitchenstudio.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

	private final OrderRepository orderRepository;

	@Autowired
	public OrderServiceImpl(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public void add(Order order) {
		orderRepository.save(order);
	}

	@Override
	public void delete(Order order) {
		orderRepository.delete(order);
	}
}
