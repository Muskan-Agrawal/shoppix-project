package com.catalog.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.catalouge.demo.service.ProductService;

@SpringBootTest
class CatalogServiceApplicationTests {

	@Autowired
	ProductService productService;
	 
	@DisplayName("check where product is in database")
	@Test
	void testProductAvailable() {
		assertTrue(productService.getProducts().size() > 0);
	}
}
