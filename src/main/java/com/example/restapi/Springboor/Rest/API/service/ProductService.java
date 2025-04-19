package com.example.restapi.Springboor.Rest.API.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.restapi.Springboor.Rest.API.entity.Product;

public interface ProductService {
	
	public Product saveProduct(Product p);

	public Product getProductByName(String name);
	
	public List<Product> getAllProducts();

	public List<Product> getProductNameorManuArea(String name, String manArea);

	public Page<Product> searchProducts(String name, int page,int size,String sortBy,String direction);

}
