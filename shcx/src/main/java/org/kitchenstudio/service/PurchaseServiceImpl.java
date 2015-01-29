package org.kitchenstudio.service;

import java.util.List;

import org.kitchenstudio.model.Purchase;
import org.kitchenstudio.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService{
	
	private final PurchaseRepository purchaseRepository;
	
	@Autowired
	public PurchaseServiceImpl(PurchaseRepository purchaseRepository) {
		this.purchaseRepository = purchaseRepository;
	}
	
	@Override
	public List<Purchase> findAll() {
		return purchaseRepository.findAll();
	}

}
