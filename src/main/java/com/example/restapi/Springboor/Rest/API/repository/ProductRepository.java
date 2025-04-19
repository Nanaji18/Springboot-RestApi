package com.example.restapi.Springboor.Rest.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restapi.Springboor.Rest.API.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}