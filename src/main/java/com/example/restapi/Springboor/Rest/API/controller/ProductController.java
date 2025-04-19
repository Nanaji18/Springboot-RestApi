package com.example.restapi.Springboor.Rest.API.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.Springboor.Rest.API.entity.Product;
import com.example.restapi.Springboor.Rest.API.service.ProductService;

@RestController
@RequestMapping("/nani")
public class ProductController {
	
	private ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService=productService;
	}
	
	@GetMapping("/name")
	public String getName() {
		return "Morukurthi Nanaji";
	}
	
	@PostMapping("/save")
	public Product saveProduct(@RequestBody Product p) {
		return productService.saveProduct(p);
	}

}
