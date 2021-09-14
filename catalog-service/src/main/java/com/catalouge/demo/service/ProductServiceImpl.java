package com.catalouge.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalouge.demo.bean.Product;
import com.catalouge.demo.persistence.ProductDao;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<Product> getProducts() {
		return productDao.getProducts();
	}

	@Override
	public Product getProductByCode(String code) {
		return productDao.getProductByCode(code);
	}

	@Override
	public Product getProductById(long id) {
		return productDao.getProductById(id);
	}

}
