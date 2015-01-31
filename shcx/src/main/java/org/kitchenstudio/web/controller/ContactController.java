package org.kitchenstudio.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.kitchenstudio.model.Contact;
import org.kitchenstudio.model.ContactItem;
import org.kitchenstudio.model.Order;
import org.kitchenstudio.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	private ContactService contactService;

	@RequestMapping({ "", "/" })
	String home(Model model) {
		List<Contact> contacts = contactService.findAll();
		model.addAttribute("contacts", contacts);
		return "contact/home";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	String detail(@PathVariable("id") Contact contact, Model model) {
		model.addAttribute(contact);
		return "contact/detail";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	String add(Model model) {
		model.addAttribute("contact", new Contact());
		return "/contact/new";
	}
	
	@RequestMapping(value = "/new", params = { "save" }, method = RequestMethod.POST)
	String create(@Valid Contact contact, BindingResult result) {
		if (result.hasErrors()) {
			return "contact/new";
		}
		contactService.save(contact, contact.getContactItems());
		return "redirect:/contact";
	}

	@RequestMapping(value = "/new", params = { "addItems" }, method = RequestMethod.POST)
	String addItems(@Valid Contact contact, BindingResult result) {

		contact.getContactItems().add(new ContactItem());
		return "contact/new";
	}

}
