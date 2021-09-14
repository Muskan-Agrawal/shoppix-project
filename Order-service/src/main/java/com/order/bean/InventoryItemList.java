package com.order.bean;

import java.util.List;

public class InventoryItemList {
	public List<InventoryItem> inventoryItemList;

	public List<InventoryItem> getInventoryItemList() {
		return inventoryItemList;
	}

	public void setInventoryItemList(List<InventoryItem> inventoryItemList) {
		this.inventoryItemList = inventoryItemList;
	}

	public InventoryItemList(List<InventoryItem> inventoryItemList) {
		super();
		this.inventoryItemList = inventoryItemList;
	}

	public InventoryItemList() {
		super();
	}
	
}
