package com.example.restapi.Springboor.Rest.API.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
		return productRepository.save(p);
	}
	@Override
	public Product getProductByName(String name) {
		return productRepository.findByName(name);
	}
	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	@Override
	public List<Product> getProductNameorManuArea(String name, String manArea) {
		return productRepository.findByNameOrManArea(name, manArea);
	}
	@Override
	public Page<Product> searchProducts(String name, int page, int size, String sortBy, String direction) {
		 
		Sort sort = direction.equalsIgnoreCase("desc") ?
                Sort.by(sortBy).descending() :
                Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);
        return productRepository.searchByName(name, pageable);	}
	
	

}
