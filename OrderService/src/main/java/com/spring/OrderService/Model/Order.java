package com.spring.OrderService.Model;

import java.util.List;

public class Order {
	private Long id;
	private String customerName;
	private List<Long> productIds;
	private String orderDate;
	public Order(Long id, String customerName, List<Long> productIds, String orderDate) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.productIds = productIds;
		this.orderDate = orderDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public List<Long> getProductIds() {
		return productIds;
	}
	public void setProductIds(List<Long> productIds) {
		this.productIds = productIds;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	
}
