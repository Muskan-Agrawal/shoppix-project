package com.inventory.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class InventoryItem {
	public InventoryItem() {
		super();
	}
	@Id
    private Long id;	
    private String productCode;
    private Integer availableQuantity ;
	
	public InventoryItem(long id, Integer availableQuantity,String productCode) {
		this.id = id;
		this.availableQuantity = availableQuantity;
		this.productCode = productCode;
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