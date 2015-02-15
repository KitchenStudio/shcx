package org.kitchenstudio.service;

import org.kitchenstudio.entity.Site;
import org.kitchenstudio.entity.StoreItem;

public interface StoreService {

	void addItem(Site site,StoreItem item);

	void addItems(Site site, Iterable<StoreItem> items);

	void subItem(Site site, StoreItem item);

	void subItems(Site site, Iterable<StoreItem> items);

}
