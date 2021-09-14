package com.catalouge.demo.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.catalouge.demo.bean.Product;
import com.catalouge.helper.ProductRowMapper;

@Repository
public class ProductDaoImpl implements ProductDao{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Product> getProducts() {
		List<Product> products=jdbcTemplate.query("SELECT * FROM PRODUCT", new ProductRowMapper());
		return products;
	}
	public Product getProductByCode(String code) {
		return jdbcTemplate.queryForObject("SELECT * FROM PRODUCT WHERE CODE=?", new ProductRowMapper(), code);
	}
	@Override
	public Product getProductById(long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM PRODUCT WHERE ID=?", new ProductRowMapper(), id);
	}
}
