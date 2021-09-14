package com.order.service;

import org.springframework.stereotype.Service;

import com.order.bean.OrderList;
import com.order.bean.Orders;
import com.order.bean.Product;
import com.order.bean.ProductList;
import com.order.exception.CodeNotFoundException;
import com.order.exception.InsufficientStockOfProductException;
import com.order.exception.NegativeQuantityException;

@Service
public interface OrderService {
	public Orders findOrderById(long id) throws CodeNotFoundException;
	public Orders findOrderByEmail(String customerEmail) throws CodeNotFoundException;
	public OrderList getAllOrders();
	public Orders createOrder(Orders order) throws NegativeQuantityException, InsufficientStockOfProductException;
	public ProductList getAllProducts();
	public Product getProductByCode(String code);
}
