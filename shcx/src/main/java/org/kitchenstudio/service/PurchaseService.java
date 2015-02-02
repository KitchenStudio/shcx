package org.kitchenstudio.service;

import java.util.List;

import org.kitchenstudio.entity.Purchase;
import org.kitchenstudio.entity.PurchaseItem;

public interface PurchaseService {

	List<Purchase> findAll();
	
	void save(Purchase purchase, List<PurchaseItem> purchaseItems);
}
