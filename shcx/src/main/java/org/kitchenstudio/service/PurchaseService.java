package org.kitchenstudio.service;

import java.util.List;

import org.kitchenstudio.model.Purchase;
import org.kitchenstudio.model.PurchaseItem;

public interface PurchaseService {

	List<Purchase> findAll();
	
	void save(Purchase purchase, List<PurchaseItem> purchaseItems);
}
