package com.order.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.order.bean.*;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class InventoryServiceImpl implements InventoryService{

	@Autowired
	private RestTemplate restTemplate;
 
	@Override
	@CircuitBreaker(name = "inventory", fallbackMethod = "getInventoryFallBack")
	public InventoryItemList getInventory() {
		return restTemplate.getForObject("http://inventory-service/inventories", InventoryItemList.class);

	}
	public InventoryItemList getInventoryFallBack() {
		List<InventoryItem> inventories = new ArrayList<InventoryItem>();
		inventories.add(new InventoryItem(null,0));
		return new InventoryItemList(inventories);
	}
	 
	@CircuitBreaker(name = "inventory", fallbackMethod = "findInventoryItemByCodeFallBack")
	@Override
	public InventoryItem findInventoryItemByCode(String productCode) {
		return restTemplate.getForObject("http://inventory-service/inventories/code/{productCode}", InventoryItem.class, productCode);
	}
	public InventoryItem findInventoryItemByCodeFallBack() {
		return new InventoryItem(null,0);
	}
	
	@CircuitBreaker(name = "inventory", fallbackMethod = "findInventoryItemByIdFallBack")
	@Override
	public InventoryItem findInventoryItemById(long id) {
		return restTemplate.getForObject("http://inventory-service/inventories/id/{id}", InventoryItem.class, id);
	}
	public InventoryItem findInventoryItemByIdFallBack() {
		return new InventoryItem(null,0);
	}
}