package org.kitchenstudio.web.controller;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.kitchenstudio.model.Driver;
import org.kitchenstudio.model.Order;
import org.kitchenstudio.model.OrderItem;
import org.kitchenstudio.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
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

		return "order/order";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	String add(Model model) {
		model.addAttribute("order", new Order());
		return "/order/new";
	}

	// @RequestMapping(value = "/new", method = RequestMethod.GET)
	// String create(Model model) {
	// if (!model.containsAttribute("order")) {
	// Order order = new Order();
	// model.addAttribute(order);
	// }
	// return "order/new";
	// }

	@RequestMapping(value = "/new", params = { "save" }, method = RequestMethod.POST)
	String create(@Valid Order order, BindingResult result) {
		if (result.hasErrors()) {
			return "order/new";
		}
		orderService.save(order, order.getOrderItems());
		return "redirect:/order";
	}

	@RequestMapping(value = "/new", params = { "addItems" }, method = RequestMethod.POST)
	String addItems(@Valid Order order, BindingResult result) {
		order.getOrderItems().add(new OrderItem());
		return "order/new";
	}

	@RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
	String info(@PathVariable("id") Order order, Model model) {
		model.addAttribute(order);
		return "order/detail";
	}

	@RequestMapping(value = "/info", method = RequestMethod.POST)
	String info(@Valid Order order, BindingResult result) {
		if (result.hasErrors()) {
			return "order/modify";
		}
		// order.getOrderItems().add(new OrderItem());
		// orderService.add(order);
		orderService.save(order, order.getOrderItems());
		return "/order/modifysuccess";
	}

	@RequestMapping(value = "/info", params = { "removeItem" }, method = RequestMethod.POST)
	String modifyRemoveItems(@Valid Order order, BindingResult result,
			HttpServletRequest req) {
		Integer rowId = Integer.valueOf(req.getParameter("removeItem"));
		order.getOrderItems().remove(rowId.intValue());
		return "order/modify";
	}

	@RequestMapping(value = "/info", params = { "modifyAddItem" }, method = RequestMethod.POST)
	String modifyAddItems(@Valid Order order, BindingResult result) {
		order.getOrderItems().add(new OrderItem());
		return "order/modify";
	}

	@RequestMapping(value = "/modify/{id}", method = RequestMethod.GET)
	String modify(@PathVariable("id") Order order, Model model) {
		model.addAttribute(order);
		return "order/modify";
	}

	@RequestMapping("/delete/{id}")
	String delete(@PathVariable("id") Order order) {
		orderService.delete(order);
		return "redirect:/order";
	}
}
