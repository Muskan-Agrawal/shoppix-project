package com.order.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class InventoryItem {
	public InventoryItem() {
		super();
	}
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productCode;
    private Integer availableQuantity ;
    
	public InventoryItem(String productCode, long id) {
		super();
		this.productCode = productCode;
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public Integer getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
    
}
