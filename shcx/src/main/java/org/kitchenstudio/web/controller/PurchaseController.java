package org.kitchenstudio.web.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.kitchenstudio.entity.Company;
import org.kitchenstudio.entity.Product;
import org.kitchenstudio.entity.ProductCategory;
import org.kitchenstudio.entity.Purchase;
import org.kitchenstudio.entity.PurchaseItem;
import org.kitchenstudio.entity.Staff;
import org.kitchenstudio.service.CompanyService;
import org.kitchenstudio.service.ProductService;
import org.kitchenstudio.service.PurchaseService;
import org.kitchenstudio.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {

	@Autowired
	private PurchaseService purchaseService;

	@Autowired
	private StaffService staffService;

	@Autowired
	private ProductService productService;

	@Autowired
	private CompanyService companyService;

	@ModelAttribute("staffs")
	List<Staff> populateStaffs() {
		return staffService.findAll();
	}

	@ModelAttribute("categories")
	List<ProductCategory> populateCategoris() {
		return productService.allCategories();
	}

	@ModelAttribute("products")
	List<Product> populateProducts() {
		return productService.findAll();
	}

	@ModelAttribute("companies")
	List<Company> populateCompanies() {
		return companyService.findAll();
	}

	@RequestMapping({ "", "/" })
	String home(Model model) {

		model.addAttribute("purchases", purchaseService.findAll());

		return "purchase/home";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	String create(Purchase purchase) {
		purchase.setCreatedTime(new Date());
		return "purchase/new";

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

	@RequestMapping(value = "/{id}/detail", method = RequestMethod.GET)
	String info(@PathVariable("id") Purchase purchase, Model model) {
		model.addAttribute(purchase);
		return "purchase/detail";

	}

	@RequestMapping(value = "/{id}/modify", method = RequestMethod.GET)
	String modify(@PathVariable("id") Purchase purchase, Model model) {
		model.addAttribute(purchase);
		return "purchase/modify";
	}

	@RequestMapping(value = "/{id}/modify", params = { "save" }, method = RequestMethod.POST)
	String modify(@Valid Purchase purchase, BindingResult result) {

		if (result.hasErrors()) {
			return "purchase/modify";
		}
		purchaseService.save(purchase, purchase.getPurchaseItems());
		return "redirect:/purchase/{id}/detail?success";

	}

	@RequestMapping(value = "/{id}/modify", params = { "addItems" }, method = RequestMethod.POST)
	String modifyItems(@Valid Purchase purchase, BindingResult result) {
		purchase.getPurchaseItems().add(new PurchaseItem());
		return "purchase/modify";

	}

	@RequestMapping("/{id}/delete")
	String delete(@PathVariable("id") Purchase purchase) {
		purchaseService.delete(purchase);
		return "redirect:/purchase";
	}

}
