package com.inventory.service;

import java.util.ArrayList;
import com.inventory.bean.InventoryItem;

public interface InventoryService {
	public InventoryItem findInventoryItemByCode(String code);
	public InventoryItem insertInventoryItem(InventoryItem inventoryItem);
	public ArrayList<InventoryItem> getInventory();
	public InventoryItem findInventoryItemById(long id) ;
}
