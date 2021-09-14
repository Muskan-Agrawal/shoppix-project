package com.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.inventory.service.InventoryService;
//import com.inventory.bean.InventoryItem;

@SpringBootApplication(scanBasePackages = "com.inventory")
@EnableJpaRepositories(basePackages = "com.inventory.persistence")
@EntityScan(basePackages = "com.inventory.bean")
@EnableEurekaClient
public class InventoryServiceApplication /*implements CommandLineRunner*/{
	
	@Autowired
	InventoryService inventoryService;
	
	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		 inventoryService.insertInventoryItem(new InventoryItem(58L,1,"P80"));
//	     inventoryService.insertInventoryItem(new InventoryItem(63,28,"P50"));
//	     inventoryService.insertInventoryItem(new InventoryItem(74,3,"P60"));
//	     inventoryService.insertInventoryItem(new InventoryItem(82,14,"P20"));
//	     inventoryService.insertInventoryItem(new InventoryItem(102,7,"P40"));
//	     inventoryService.insertInventoryItem(new InventoryItem(11,23,"P10"));
//	     inventoryService.insertInventoryItem(new InventoryItem(14,10,"P70"));
//	     inventoryService.insertInventoryItem(new InventoryItem(34,3,"P30"));
//	}
	
	

}
