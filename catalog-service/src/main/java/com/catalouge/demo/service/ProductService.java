package com.catalouge.demo.service;

import java.util.List;

import com.catalouge.demo.bean.Product;

public interface ProductService {
	public List<Product> getProducts();
	public Product getProductByCode(String code);
	public Product getProductById(long id);

}
