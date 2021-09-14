package com.catalouge.demo.persistence;

import java.util.List;

import com.catalouge.demo.bean.Product;

public interface ProductDao {
	public List<Product> getProducts();
	public Product getProductByCode(String code);
	public Product getProductById(long id);
}
