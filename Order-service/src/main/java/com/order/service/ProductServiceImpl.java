package com.order.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.order.bean.Product;
import com.order.bean.ProductList;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	RestTemplate restTemplate;
	
	@Override
	@CircuitBreaker(name = "catalog",fallbackMethod = "getProductsFallBack")
	public ProductList getProducts() {
		return restTemplate.getForObject("http://catalog-service/products", ProductList.class);
	}
	
	public ProductList getProductsFallBack() {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(0,"Dummy","DummyProduct","",0));
		return new ProductList(products);
	}

	@Override
	@CircuitBreaker(name = "catalog",fallbackMethod = "getProductByCodeFallBack")
	public Product getProductByCode(String code) {
		return restTemplate.getForObject("http://catalog-service/products/code/{code}", Product.class, code);
	}

	public Product getProductByCodeFallBack() {
		return new Product(0,"Dummy","DummyProduct","",0);
	}
	
	@Override
	@CircuitBreaker(name = "catalog",fallbackMethod = "getProductByIdFallBack")
	public Product getProductById(long id) {
		return restTemplate.getForObject("http://catalog-service/products/id/{id}", Product.class, id);
	}
	
	public Product getProductByIdFallBack() {
		return new Product(0,"Dummy","DummyProduct","",0);
	}
	

}
