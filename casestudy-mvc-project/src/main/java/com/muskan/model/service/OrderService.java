package com.muskan.model.service;

import com.muskan.bean.*;
import java.util.List;

import org.springframework.stereotype.Service;

import com.order.exception.CodeNotFoundException;
import com.order.exception.InsufficientStockOfProductException;
import com.order.exception.NegativeQuantityException;

@Service
public interface OrderService {
	public List<Orders> getAllOrders();
	public Orders createOrder(Orders order) throws NegativeQuantityException, InsufficientStockOfProductException;
	public List<Product> getAllProducts();
	//public Product getProductByCode(String code);
	//public Orders addProductToList(Orders order, Product product);
	public Orders findOrderById(long id) throws CodeNotFoundException;
	public Orders findOrderByEmail(String customerEmail) throws CodeNotFoundException;
}
