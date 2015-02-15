package org.kitchenstudio.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.kitchenstudio.entity.Purchase;
import org.kitchenstudio.entity.PurchaseItem;
import org.kitchenstudio.repository.PurchaseItemRepository;
import org.kitchenstudio.repository.PurchaseRepository;
import org.kitchenstudio.service.PurchaseService;
import org.kitchenstudio.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	private final PurchaseRepository purchaseRepository;
	private final PurchaseItemRepository purchaseItemRepository;

	@Autowired
	private StoreService storeService;

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

		purchaseItemRepository.save(purchaseItems);
		purchaseRepository.save(purchase);

		// 仓库增加
		purchaseItems.forEach((item) -> {
			storeService.addItem(purchase.getSite(), item);
		});

	}

	@Override
	public void delete(Purchase purchase) {
		purchaseRepository.delete(purchase);
	}
}
