package com.order.service;

import com.order.bean.Product;
import com.order.bean.ProductList;

public interface ProductService {
	public ProductList getProducts();
	public Product getProductByCode(String code);
	public Product getProductById(long id);

}
