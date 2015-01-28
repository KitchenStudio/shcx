package org.kitchenstudio.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.kitchenstudio.model.Order;
import org.kitchenstudio.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/order")
public class OrderController {

	private static final Logger log = LoggerFactory
			.getLogger(OrderController.class);

	@Autowired
	private OrderService orderService;

	@RequestMapping({ "", "/" })
	String home(Model model) {
		List<Order> orders = orderService.findAll();
		model.addAttribute("orders", orders);

		return "order";
	}

	@RequestMapping({ "/add" })
	String add(Order order) {
		orderService.add(order);
		return "redirect:/order";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	String create(Model model) {
		if (!model.containsAttribute("order")) {
			Order order = new Order();
			model.addAttribute(order);
		}

		return "order_new";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	String create(@Valid Order orver, BindingResult result) {
		if (result.hasErrors()) {
			return "order_new";
		}
		return "redirect:/driver/new";
	}

	@RequestMapping("/delete/{id}")
	String delete(@PathVariable("id") Order driver) {
		orderService.delete(driver);
		return "redirect:/driver";
	}

}
