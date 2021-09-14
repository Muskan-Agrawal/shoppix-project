package com.order.service;

import com.order.bean.InventoryItem;
import com.order.bean.InventoryItemList;

public interface InventoryService {
	public InventoryItem findInventoryItemByCode(String code);
	public InventoryItemList getInventory();
	public InventoryItem findInventoryItemById(long id) ;
}
