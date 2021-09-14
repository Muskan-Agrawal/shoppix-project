package com.order.bean;

import java.util.List;

public class ProductList {
	public List<Product> productList;

	public ProductList() {
		super();
	}

	public ProductList(List<Product> productList) {
		super();
		this.productList = productList;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
	public int size() {
		return this.productList.size();
	}
}
