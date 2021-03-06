package org.kitchenstudio.controller;

import org.kitchenstudio.entity.Order;
import org.kitchenstudio.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
public class OrderRestController {

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
	void delete(@PathVariable("id") Order order) {
		orderService.delete(order);
	}
}
