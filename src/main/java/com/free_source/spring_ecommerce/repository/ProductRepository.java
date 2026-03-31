package com.free_source.spring_ecommerce.repository;

import com.free_source.spring_ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Fetches a single product with all its collections (specifications, variants, features) 
     * in one query to avoid LazyInitializationException.
     */
    @Query("SELECT p FROM Product p " +
       "LEFT JOIN FETCH p.specifications s " + // Named 's' for sorting
       "LEFT JOIN FETCH p.variants " +
       "LEFT JOIN FETCH p.features " +
       "WHERE p.id = :id " +
       "ORDER BY s.specGroup ASC") // Ensures Display specs stay together
Optional<Product> findProductWithAllDetails(@Param("id") Long id);

    /**
     * Fetches up to 4 related products in the same category, excluding the current product.
     * This uses Spring Data JPA's method name convention.
     */
    List<Product> findTop4ByCategoryAndIdNot(String category, Long id);
}