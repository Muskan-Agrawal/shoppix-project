package com.catalouge.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.catalouge.demo.bean.Product;

public class ProductRowMapper implements RowMapper<Product> {
	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product=new Product();
		
		product.setId(rs.getLong("id"));
		product.setCode(rs.getString("code"));
		product.setName(rs.getString("name"));
		product.setDescription(rs.getString("description"));
		product.setPrice(rs.getDouble("price"));
		
		return product;
	}
}
