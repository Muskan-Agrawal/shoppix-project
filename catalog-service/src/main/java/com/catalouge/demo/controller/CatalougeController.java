package com.catalouge.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.catalouge.demo.bean.Product;
import com.catalouge.demo.service.ProductService;

@CrossOrigin
@RestController
public class CatalougeController {

	@Autowired
	ProductService productService;
	
	//get the catalouge
	@GetMapping("/products")
	public List<Product> getProducts() {
		return productService.getProducts();
	}
	
	//get catalouge by code
	@GetMapping("/products/code/{code}")
	public Product getProductByCode(@PathVariable String code) {
		return productService.getProductByCode(code);
	}
	
	@GetMapping("/products/id/{id}")
	public Product getProductById(@PathVariable long id) {
		return productService.getProductById(id);
	}
	
}
