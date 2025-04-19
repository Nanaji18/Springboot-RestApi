package com.example.restapi.Springboor.Rest.API.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restapi.Springboor.Rest.API.entity.Product;
import com.example.restapi.Springboor.Rest.API.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService{
    
	
	private ProductRepository productRepository;
	
	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository=productRepository;
	}
	@Override
	public Product saveProduct(Product p) {
		// TODO Auto-generated method stub
		return productRepository.save(p);
	}

}
