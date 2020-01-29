package com.securiteS.box.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.securiteS.box.entities.Product;


public interface ProductRepository extends JpaRepository<Product, Long>{

}
