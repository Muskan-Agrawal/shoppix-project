package com.inventory.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.service.InventoryService;
import com.inventory.bean.InventoryItem;

@CrossOrigin
@RestController
public class InventoryController {
	@Autowired
	InventoryService inventoryService;

	@GetMapping("/inventories")
	public ArrayList<InventoryItem> getInventory(){
        return inventoryService.getInventory();	
	}
	
	@GetMapping("/inventories/code/{productCode}")
	public InventoryItem findInventoryItemByCode(@PathVariable String productCode) {
		return inventoryService.findInventoryItemByCode(productCode);
	}
	
	@GetMapping("/inventories/id/{id}")
	public InventoryItem findInventoryItemByProductId(@PathVariable long id) {
		return inventoryService.findInventoryItemById(id);
	}
	
}
