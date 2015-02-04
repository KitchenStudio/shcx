package org.kitchenstudio.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.kitchenstudio.entity.Contract;
import org.kitchenstudio.entity.ContractItem;
import org.kitchenstudio.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/contract")
public class ContractController {

	@Autowired
	private ContractService contractService;

	@RequestMapping({ "", "/" })
	String home(Model model) {
		List<Contract> contracts = contractService.findAll();
		model.addAttribute("contracts", contracts);
		return "contract/home";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	String detail(@PathVariable("id") Contract contract, Model model) {
		model.addAttribute("contract",contract);
		return "contract/detail";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	String add(Model model) {
		model.addAttribute("contract", new Contract());
		return "/contract/new";
	}

	@RequestMapping(value = "/new", params = { "save" }, method = RequestMethod.POST)
	String create(@Valid Contract contract, BindingResult result) {
		if (result.hasErrors()) {
			return "contract/new";
		}
		contractService.save(contract, contract.getContractItems());
		return "redirect:/contract";
	}

	@RequestMapping(value = "/new", params = { "addItems" }, method = RequestMethod.POST)
	String addItems(@Valid Contract contract, BindingResult result) {

		contract.getContractItems().add(new ContractItem());
		return "contract/new";
	}

}
