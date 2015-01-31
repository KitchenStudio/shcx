package org.kitchenstudio.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.kitchenstudio.model.Purchase;
import org.kitchenstudio.model.PurchaseItem;
import org.kitchenstudio.repository.PurchaseItemRepository;
import org.kitchenstudio.repository.PurchaseRepository;
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
		purchase = purchaseRepository.save(purchase);
		List<PurchaseItem> items = new ArrayList<>();
		for (PurchaseItem item : purchaseItems) {
			items.add(purchaseItemRepository.save(item));
		}

		purchase.setPurchaseItems(items);
		purchaseRepository.save(purchase);
	}

}
