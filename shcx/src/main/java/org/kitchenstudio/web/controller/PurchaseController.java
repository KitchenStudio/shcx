package org.kitchenstudio.web.controller;

import java.util.Collections;

import org.kitchenstudio.model.Purchase;
import org.kitchenstudio.model.PurchaseItem;
import org.kitchenstudio.model.Staff;
import org.kitchenstudio.service.PurchaseService;
import org.kitchenstudio.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {
	
	@Autowired
	private PurchaseService purchaseService;
	
	@Autowired
	private StaffService staffService;
	
	@RequestMapping({"", "/"})
	String home(Model model){
		
		Purchase purchase = new Purchase();
		Staff buyer = staffService.findAll().get(0);
		System.out.println(buyer.getName());
		System.out.println(buyer.getId());
		purchase.setBuyer(buyer);
		
		PurchaseItem item = new PurchaseItem();
		item.setKind("钢管");
		item.setQuantity(10);
		item.setRemark("很少");
		
		purchaseService.save(purchase, Collections.singletonList(item));
		
		model.addAttribute("purchases", purchaseService.findAll());
		
		return "purchase/home";
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	String create(){
		return "purchase/new";
	}
	
	String create(Model model) {
		return "";
	}

	
	
}
