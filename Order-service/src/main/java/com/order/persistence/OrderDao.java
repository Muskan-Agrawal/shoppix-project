package com.order.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.bean.Orders;

@Repository
public interface OrderDao extends JpaRepository<Orders, Long>{
	public Orders getOrdersById(long id);
	public Orders getOrderByCustomerEmail(String email);
}
