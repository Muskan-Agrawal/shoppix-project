package com.muskan.model.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.muskan.bean.InventoryItem;
import com.muskan.bean.OrderItems;
import com.muskan.bean.Orders;
import com.muskan.bean.Product;
import com.order.exception.CodeNotFoundException;
import com.order.exception.InsufficientStockOfProductException;
import com.order.exception.NegativeQuantityException;
import com.muskan.model.persistence.OrderDao;

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
			long id = orderItem.getProductId();
			if(orderItem.getQuantity()<1) {

				throw new NegativeQuantityException();
			}

			InventoryItem inventoryItem = restTemplate.getForObject(
					"http://localhost:8085/inventories/id/{id}", InventoryItem.class, orderItem.getProductId());
			if( inventoryItem.getAvailableQuantity() < orderItem.getQuantity()) {

				throw new InsufficientStockOfProductException();
			}

			Product product = restTemplate.getForObject(
					"http://localhost:8084/products/id/{id}", Product.class,orderItem.getProductId() );

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
	public List<Orders> getAllOrders() {
		return orderDao.findAll();
	}

	@Override
	public List<Product> getAllProducts() {
		Product[] products=restTemplate.getForObject("http://localhost:8084/products/", Product[].class);
		List<Product> productsArray=new ArrayList<Product>();
		for(Product p :products)
			productsArray.add(p);
		
		return productsArray;	
	}
	
	@Override
	public Orders findOrderByEmail(String customerEmail) throws CodeNotFoundException {
		Optional<Orders> customerOrder = Optional.of(orderDao.getOrderByCustomerEmail(customerEmail));
		if(customerOrder.isPresent())
			return (Orders) customerOrder.get();
		else
			throw new CodeNotFoundException();
	} 

}
