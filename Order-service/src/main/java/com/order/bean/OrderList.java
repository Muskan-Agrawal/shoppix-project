package com.order.bean;

import java.util.List;

public class OrderList {
	public List<Orders> orderList;

	public List<Orders> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Orders> orderList) {
		this.orderList = orderList;
	}

	public OrderList(List<Orders> orderList) {
		super();
		this.orderList = orderList;
	}

	public OrderList() {
		super();
	}
}
