package com.spring.ProductService.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ProductService.Model.Product;

@RestController
@RequestMapping("/products")
public class ProductController {

	private List<Product> products = new ArrayList();

	public ProductController() {
		products.add(new Product(1L, "CPU", "desktop", 1000, "cpu.png"));
		products.add(new Product(2L, "Pendrive", "USB", 500, "usb.png"));
	}

	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id) {
		return products.stream().filter(product -> product.getId()).equals(id).findFirst()
				.orElseThrow(() -> new ProductNotFoundException("Product not found with id :" + id));
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler()
	public String handleProductNotFound(ProductNotFoundException ex) {
		return ex.getMessage();
	}

	class ProductNotFoundException extends RuntimeException {
		public ProductNotFoundException(String message) {
			super(message);
		}
	}
	//SQL for Product Table
	//CREATE TABLE products(id BIGINT AUTO_INCREMENT PRIMARY KEY,name VARCHAR(255) NOT NULL,
	//description VARCHAR(255) NOT NULL, price DOUBLE NOT NULL, image_url VARCHAR(255);
}
