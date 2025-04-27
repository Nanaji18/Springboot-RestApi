package com.example.restapi.Springboor.Rest.API.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/{pname}")
	public Product getProductbyName(@PathVariable String pname) {
		return productService.getProductByName(pname);
	}
	@GetMapping("/gt")
	public List<Product> getAllProduct() {
		return productService.getAllProducts();
	}
	
	@GetMapping("/getProOrMan")
	public List<Product> getProductNameorManuArea(@RequestParam(required = false) String name,@RequestParam(required = false) String manArea){
		return productService.getProductNameorManuArea(name,manArea);
	}
	
	 @GetMapping("/search")
	    public Page<Product> searchProducts(
	            @RequestParam(required = false) String name,
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "1") int size,
	            @RequestParam(defaultValue = "name") String sortBy,
	            @RequestParam(defaultValue = "asc") String direction
	    ) {
		 

	        return productService.searchProducts(name, page,size,sortBy,direction);
	    }
	 
	 @PutMapping("/update")
	 public Product updateProduct(@RequestBody Product product) {
		 return productService.updateProduct(product);
	 }
	 
	 @DeleteMapping("/delete/{id}")
	 public String deleteProduct(@PathVariable long id) {
		 return productService.deleteProductbyid(id);
	 }
	 
	 @PatchMapping("/updateSpecific")
	 public Product updateSpecificColumn(@RequestBody Product product) {
		 return productService.updateSpecificColumn(product);
	 }
		
	

}
