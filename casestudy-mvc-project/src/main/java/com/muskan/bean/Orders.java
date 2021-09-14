package com.muskan.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Orders {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String customerEmail;
	private String customerAddress;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<OrderItems> orderItem;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public List<OrderItems> getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(List<OrderItems> orderItem) {
		this.orderItem = orderItem;
	}
	public Orders() {
		super();
	}
	public Orders(long id, String customerEmail, String customerAddress, List<OrderItems> orders) {
		super();
		this.id = id;
		this.customerEmail = customerEmail;
		this.customerAddress = customerAddress;
		this.orderItem = orders;
	}
	public Orders(String email, String address, List<OrderItems> orderItems) {
		this.customerEmail = email;
		this.customerAddress = address;
		this.orderItem = orderItems;
	}
}
