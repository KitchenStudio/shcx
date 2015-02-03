package org.kitchenstudio.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.kitchenstudio.entity.Contract;
import org.kitchenstudio.entity.ContractItem;
import org.kitchenstudio.repository.ContractItemRepository;
import org.kitchenstudio.repository.ContractRepository;
import org.kitchenstudio.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements ContractService {

	private final ContractRepository contractRepository;
	private final ContractItemRepository contractItemRepository;

	@Autowired
	public ContractServiceImpl(ContractRepository contractRepository,
			ContractItemRepository contractItemRepository) {
		this.contractRepository = contractRepository;
		this.contractItemRepository = contractItemRepository;
	}

	@Override
	public List<Contract> findAll() {
		return contractRepository.findAll();
	}

	@Override
	public void save(Contract contract, List<ContractItem> contractItems) {
		List<ContractItem> savedItems = new LinkedList<>();
		for (ContractItem contractItem : contractItems) {
			savedItems.add(contractItemRepository.save(contractItem));
		}

		contract.setContractItems(savedItems);
		contractRepository.save(contract);
	}

}
