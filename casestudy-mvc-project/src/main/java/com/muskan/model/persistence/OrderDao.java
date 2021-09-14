package com.muskan.model.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muskan.bean.Orders;

@Repository
public interface OrderDao extends JpaRepository<Orders, Long>{
	public Orders getOrdersById(long id);

	public Orders getOrderByCustomerEmail(String customerEmail);
}
