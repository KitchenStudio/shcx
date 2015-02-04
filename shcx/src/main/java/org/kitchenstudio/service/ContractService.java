package org.kitchenstudio.service;

import java.util.List;

import org.kitchenstudio.entity.Contract;
import org.kitchenstudio.entity.ContractItem;

public interface ContractService {

	List<Contract> findAll();

	void save(Contract contract, List<ContractItem> contractItems);

}
