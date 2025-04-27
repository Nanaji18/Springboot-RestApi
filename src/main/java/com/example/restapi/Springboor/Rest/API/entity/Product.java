package com.example.restapi.Springboor.Rest.API.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Double price;
	private String manArea;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getManArea() {
		return manArea;
	}

	public void setManArea(String manArea) {
		this.manArea = manArea;
	}

	public Product(Long id, String name, Double price, String manArea) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.manArea = manArea;
	}

	public Product() {
		super();
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", manArea=" + manArea + "]";
	}
	
	
	
	
	
	

}
