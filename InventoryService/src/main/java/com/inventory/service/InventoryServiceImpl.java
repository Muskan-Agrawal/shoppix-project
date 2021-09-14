package com.inventory.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.inventory.persistence.*;
import com.inventory.bean.*;

@Service
public class InventoryServiceImpl implements InventoryService{
	
	@Autowired
	private InventoryDao inventoryDao;
	@Autowired
	private RestTemplate restTemplate;
 
	public ArrayList<InventoryItem> getInventory() {
		return (ArrayList<InventoryItem>) inventoryDao.findAll();
	}
	 
	@Override
	public InventoryItem findInventoryItemByCode(String productCode) {
		return inventoryDao.getInventoryItemByProductCode(productCode);
	}
	
	public InventoryItem insertInventoryItem(InventoryItem inventoryItem) {
		return inventoryDao.save(inventoryItem);
	}

	@Override
	public InventoryItem findInventoryItemById(long id) {
		Product product = restTemplate.getForObject("http://catalog-service/products/id/{id}", Product.class, id);
		String productCode = product.getCode();
		return inventoryDao.getInventoryItemByProductCode(productCode);
	}	
}