package org.kitchenstudio.service.impl;

import java.math.BigDecimal;

import org.kitchenstudio.entity.Site;
import org.kitchenstudio.entity.Store;
import org.kitchenstudio.entity.StoreItem;
import org.kitchenstudio.repository.StoreRepository;
import org.kitchenstudio.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreRepository storeRepository;

	@Override
	public void addItem(Site site, StoreItem item) {
		Store store = storeRepository.findBySiteAndProduct(site,
				item.getProduct());
		store.setQuantity(store.getQuantity().add(
				new BigDecimal(item.getSpecification().getDim()
						* item.getQuantity())));
		storeRepository.save(store);
	}

	@Override
	public void addItems(Site site, Iterable<StoreItem> items) {
		for (StoreItem item : items) {
			addItem(site, item);
		}
	}

	@Override
	public void subItem(Site site, StoreItem item) {
		Store store = storeRepository.findBySiteAndProduct(site,
				item.getProduct());
		store.setQuantity(store.getQuantity().subtract(
				new BigDecimal(item.getSpecification().getDim()
						* item.getQuantity())));
		storeRepository.save(store);
	}

	@Override
	public void subItems(Site site, Iterable<StoreItem> items) {
		for (StoreItem item : items) {
			subItem(site, item);
		}
	}

}
