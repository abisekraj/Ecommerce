package com.spring.OrderService.Model;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="product-service",url="http://localhost:8081")
public class ProductServiceClient {

	@GetMapping("/products/{id}")
	String getProductDetails(@PathVariable("id") Long id);

	@GetMapping("/products")
	List<String> getProductDetails(List<Long> ids);
}
