package com.order.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.order.bean.InventoryItem;
import com.order.bean.OrderItems;
import com.order.bean.OrderList;
import com.order.bean.Orders;
import com.order.bean.Product;
import com.order.bean.ProductList;
import com.order.exception.CodeNotFoundException;
import com.order.exception.InsufficientStockOfProductException;
import com.order.exception.NegativeQuantityException;
import com.order.persistence.OrderDao;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderDao orderDao;
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Orders createOrder(Orders order) throws NegativeQuantityException, InsufficientStockOfProductException {
		List<OrderItems> orderItems =  order.getOrderItem();

		for(OrderItems orderItem: orderItems) {
			if(orderItem.getQuantity()<1) {

				throw new NegativeQuantityException();
			}

			InventoryItem inventoryItem = restTemplate.getForObject(
					"http://inventory-service/inventories/id/{id}", InventoryItem.class, orderItem.getProductId());
			if( inventoryItem.getAvailableQuantity() < orderItem.getQuantity()) {

				throw new InsufficientStockOfProductException();
			}

			Product product = restTemplate.getForObject(
					"http://catalog-service/products/id/{id}", Product.class,orderItem.getProductId() );

			orderItem.setProductPrice(BigDecimal.valueOf(product.getPrice()));
		}

		return orderDao.save(order);
	}

	@Override
	public Orders findOrderById(long id) throws CodeNotFoundException {
		Optional<Orders> customerOrder = (orderDao.findById(id));
		if(customerOrder.isPresent())
			return customerOrder.get();
		else
			throw new CodeNotFoundException();
	}

	@Override
	public OrderList getAllOrders() {
		OrderList orderList = new OrderList(orderDao.findAll());
		return orderList;
	}

	@Override
	public ProductList getAllProducts() {
		Product[] products=restTemplate.getForObject("http://catalog-service/products/", Product[].class);
		List<Product> productsArray=new ArrayList<Product>();
		for(Product p :products)
			productsArray.add(p);
		
		return new ProductList(productsArray);	
	}

	@Override
	public Product getProductByCode(String code) {
		return restTemplate.getForObject("http://catalog-service/products/code/{code}",Product.class,code);
	}

	@Override
	public Orders findOrderByEmail(String email) throws CodeNotFoundException {
		Optional<Orders> customerOrder = Optional.of((orderDao.getOrderByCustomerEmail(email)));
		if(customerOrder.isPresent())
			return customerOrder.get();
		else
			throw new CodeNotFoundException();
	}
}
