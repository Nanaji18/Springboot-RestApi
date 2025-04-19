package com.example.restapi.Springboor.Rest.API.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.restapi.Springboor.Rest.API.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	Product findByName(String name);
    
	@Query(value = "SELECT * FROM PRODUCT " +
            "WHERE (:name IS NULL OR NAME = :name) " +
            "OR (:manArea IS NULL OR MAN_AREA = :manArea)",
    nativeQuery = true)
	List<Product> findByNameOrManArea(@Param("name") String name, @Param("manArea") String manArea);
    
	
	@Query(value = "SELECT * FROM PRODUCT " +
            "WHERE (:name IS NOT NULL AND LOWER(NAME) LIKE LOWER('%' || :name || '%'))",
            countQuery = "SELECT COUNT(*) FROM PRODUCT " +
            "WHERE (:name IS NOT NULL AND LOWER(NAME) LIKE LOWER('%' || :name || '%'))",
            nativeQuery = true)
	Page<Product> searchByName(@Param("name") String name, Pageable pag);

}