package org.kitchenstudio.service;

import java.util.List;

import org.kitchenstudio.model.Purchase;

public interface PurchaseService {

	List<Purchase> findAll();
}
