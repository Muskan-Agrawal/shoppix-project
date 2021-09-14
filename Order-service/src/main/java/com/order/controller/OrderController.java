package com.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.order.bean.OrderList;
import com.order.bean.Orders;
import com.order.exception.CodeNotFoundException;
import com.order.exception.InsufficientStockOfProductException;
import com.order.exception.NegativeQuantityException;
import com.order.service.OrderService;

@RestController
@CrossOrigin
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping(path = "/orders" ,method=RequestMethod.GET,produces=  "Application/json")
	public OrderList listallOrders() {
		return orderService.getAllOrders();
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping(path ="/orders/id/{id}", produces="Application/json")
	public ResponseEntity getOrderById(@PathVariable("id") long id) {
		try {
			return ResponseEntity
					.status(HttpStatus.CREATED)
					.body(orderService.findOrderById(id));
		} catch (CodeNotFoundException e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping(path="/orders/put",produces = "Application/json", consumes="Application/json")
	public ResponseEntity makeOrder(@RequestBody Orders order) {
		try {
			orderService.createOrder(order);
			return ResponseEntity.ok("Order Created Successfully");
		} catch (NegativeQuantityException e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (InsufficientStockOfProductException e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping(path ="/orders/email/{email}", produces="Application/json")
	public ResponseEntity getOrderById(@PathVariable("id") String email) {
		try {
			return ResponseEntity
					.status(HttpStatus.CREATED)
					.body(orderService.findOrderByEmail(email));
		} catch (CodeNotFoundException e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
