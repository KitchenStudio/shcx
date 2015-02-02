package org.kitchenstudio.web.controller;

import javax.validation.Valid;

import org.kitchenstudio.entity.Purchase;
import org.kitchenstudio.entity.PurchaseItem;
import org.kitchenstudio.service.PurchaseService;
import org.kitchenstudio.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {

	@Autowired
	private PurchaseService purchaseService;

	@Autowired
	private StaffService staffService;

	@RequestMapping({ "", "/" })
	String home(Model model) {

		// Purchase purchase = new Purchase();
		// Staff buyer = staffService.findAll().get(0);
		// System.out.println(buyer.getName());
		// System.out.println(buyer.getId());
		// purchase.setBuyer(buyer.getName());
		//
		// PurchaseItem item = new PurchaseItem();
		// item.setKind("钢管");
		// item.setQuantity(10);
		// item.setRemark("很少");

		// purchaseService.save(purchase, Collections.singletonList(item));

		model.addAttribute("purchases", purchaseService.findAll());

		return "purchase/home";
	}

	@RequestMapping(value = "/new", params = { "save" }, method = RequestMethod.POST)
	String save(@Valid Purchase purchase, BindingResult result) {
		if (result.hasErrors()) {
			for (int i = 0; i < result.getAllErrors().size(); i++) {
				System.out.println("有错误" + result.getAllErrors().get(i));
			}

			return "purchase/new";
		}
		purchaseService.save(purchase, purchase.getPurchaseItems());
		return "redirect:/purchase";

	}

	@RequestMapping(value = "/new", params = { "addItems" }, method = RequestMethod.POST)
	String createItems(@Valid Purchase purchase, BindingResult result) {
		purchase.getPurchaseItems().add(new PurchaseItem());
		return "purchase/new";

	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	String create(@Valid Purchase purchase, BindingResult result) {

		return "purchase/new";

	}

	String create(Model model) {
		return "";
	}

}
