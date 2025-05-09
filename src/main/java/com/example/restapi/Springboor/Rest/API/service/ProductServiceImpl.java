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
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;

	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
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

		Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();

		Pageable pageable = PageRequest.of(page, size, sort);
		return productRepository.searchByName(name, pageable);
	}

	@Override
	public Product updateProduct(Product product) {
		return productRepository.findById(product.getId()).map(ep -> {
			ep.setName(product.getName());
			ep.setManArea(product.getManArea());
			ep.setPrice(product.getPrice());
			return productRepository.save(product);
		}).orElseThrow(() -> new RuntimeException("product with id:" + product.getId() + " doesn't exist"));

	}

	@Override
	public String deleteProductbyid(long id) {
		return productRepository.findById(id).map(product -> {
            productRepository.deleteById(id);
            return "Product deleted successfully.";
        }).orElse("product with id:"+id+" doesn't exist");
		
	}

	@Override
	public Product updateSpecificColumn(Product product) {
		return productRepository.findById(product.getId())
	            .map(existingProduct -> {
	                if (product.getName() != null) {
	                    existingProduct.setName(product.getName());
	                }
	                if (product.getManArea() != null) {
	                    existingProduct.setManArea(product.getManArea());
	                }
	                if (product.getPrice() != null) {
	                    existingProduct.setPrice(product.getPrice());
	                }
	                return productRepository.save(existingProduct);
	            })
	            .orElseThrow(() -> new RuntimeException("Product not found with ID: " + product.getId()));
	  
	}

}
