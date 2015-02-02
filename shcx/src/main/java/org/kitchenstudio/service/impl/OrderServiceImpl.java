package org.kitchenstudio.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.kitchenstudio.entity.Order;
import org.kitchenstudio.entity.OrderItem;
import org.kitchenstudio.repository.OrderItemRepository;
import org.kitchenstudio.repository.OrderRepository;
import org.kitchenstudio.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

	private final OrderRepository orderRepository;
	private final OrderItemRepository orderItemRepository;

	@Autowired
	public OrderServiceImpl(OrderRepository orderRepository,
			OrderItemRepository orderItemRepository) {
		this.orderRepository = orderRepository;
		this.orderItemRepository = orderItemRepository;
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

	@Override
	public void save(Order order, List<OrderItem> orderitems) {
		List<OrderItem> savedItems = new LinkedList<>();
		for (OrderItem orderItem : orderitems) {
			savedItems.add(orderItemRepository.save(orderItem));
		}
		order.setOrderItems(savedItems);
		orderRepository.save(order);
	}

}