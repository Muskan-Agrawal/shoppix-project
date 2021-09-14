package com.inventory.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.bean.InventoryItem;

@Repository
public interface InventoryDao extends JpaRepository<InventoryItem,Long>{
	
	 InventoryItem getInventoryItemByProductCode(String productCode);
}