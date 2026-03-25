package com.free_source.spring_ecommerce.repository;

import com.free_source.spring_ecommerce.model.Product; // Exact Import
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}