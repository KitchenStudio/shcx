package org.kitchenstudio.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.kitchenstudio.entity.Purchase;
import org.kitchenstudio.entity.PurchaseItem;
import org.kitchenstudio.repository.PurchaseItemRepository;
import org.kitchenstudio.repository.PurchaseRepository;
import org.kitchenstudio.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	private final PurchaseRepository purchaseRepository;
	private final PurchaseItemRepository purchaseItemRepository;

	@Autowired
	public PurchaseServiceImpl(PurchaseRepository purchaseRepository,
			PurchaseItemRepository purchaseItemRepository) {
		this.purchaseRepository = purchaseRepository;
		this.purchaseItemRepository = purchaseItemRepository;
	}

	@Override
	public List<Purchase> findAll() {
		return purchaseRepository.findAll();
	}

	@Override
	public void save(Purchase purchase, List<PurchaseItem> purchaseItems) {
		List<PurchaseItem> items = new ArrayList<>();
		for (PurchaseItem item : purchaseItems) {
			items.add(purchaseItemRepository.save(item));
		}

		purchase.setPurchaseItems(items);
		purchaseRepository.save(purchase);
	}

	@Override
	public void delete(Purchase purchase) {
		// TODO Auto-generated method stub
		purchaseRepository.delete(purchase);
	}
}
