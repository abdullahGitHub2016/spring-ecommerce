package com.free_source.spring_ecommerce.service;

import com.free_source.spring_ecommerce.model.Product; // Import this!
import com.free_source.spring_ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    // Ensure the return type is explicitly List<Product>
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findProductWithAllDetails(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }
    
    // Add this new method
    public List<Product> getRelatedProducts(String category, Long currentProductId) {
        return productRepository.findTop4ByCategoryAndIdNot(category, currentProductId);
    }
}