package com.spring.OrderService.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.OrderService.Model.Order;
import com.spring.OrderService.Model.ProductServiceClient;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private ProductServiceClient  productServiceClient;
	
	@PostMapping
	public String createOrder(@RequestBody Order order)
	{
		try{
			List<String> productDetails= productServiceClient.getProductDetails(order.getProductIds());
			return "Order created for products :"+productDetails;
		}catch(Exception e)
		{
			return "Error Creating Order :"+e.getMessage();
		}
	}
	
	
		//SQL for Orders and Order_products Table

	//CREATE TABLE orders(id BIGINT AUTO_INCREMENT PRIMARY KEY,customer_name VARCHAR(255) NOT NULL,
	//order_date DATE NOT NULL);
	
	//CREATE TABLE order_products(order_id BIGINT,product_id BIGINT
	//FOREIGN KEY(order_id) REFERENCES orders(id),
	//FOREIGN KEY(product_id) REFERENCES products(id));
	
	
	//Make a POST Request to the order service with an order payload
	//{"customerName":"abisek", "productIds":[1,2],"orderDate":"1994-06-02"}
}
