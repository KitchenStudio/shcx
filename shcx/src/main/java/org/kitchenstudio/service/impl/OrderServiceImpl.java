package org.kitchenstudio.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.kitchenstudio.entity.Order;
import org.kitchenstudio.entity.OrderItem;
import org.kitchenstudio.entity.OrderType;
import org.kitchenstudio.entity.Store;
import org.kitchenstudio.repository.OrderItemRepository;
import org.kitchenstudio.repository.OrderRepository;
import org.kitchenstudio.repository.StoreRepository;
import org.kitchenstudio.service.OrderService;
import org.kitchenstudio.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

	private final OrderRepository orderRepository;
	private final OrderItemRepository orderItemRepository;

	@Autowired
	private StoreService storeService;

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
		orderItemRepository.save(orderitems);
		orderRepository.save(order);

		if (!order.getType().equals(OrderType.PLAN)) {
			// 存到仓库
			orderitems.forEach(item -> {
				storeService.addItem(order.getToSite(), item);
			});

			orderitems.forEach(item -> {
				storeService.subItem(order.getFromSite(), item);
			});
		}
	}

}
