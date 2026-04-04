package com.free_source.spring_ecommerce.service;

import com.free_source.spring_ecommerce.model.Product; // Import this!
import com.free_source.spring_ecommerce.model.ProductSpecification;
import com.free_source.spring_ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import java.util.Map;

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

    public Map<String, List<ProductSpecification>> getGroupedSpecifications(Long productId) {
    Product product = productRepository.findProductWithAllDetails(productId)
            .orElseThrow(() -> new RuntimeException("Product not found"));
    
    // This groups the specs into a Map: "Display" -> [List of specs]
    return product.getSpecifications().stream()
            .collect(Collectors.groupingBy(
                ProductSpecification::getSpecGroup, 
                LinkedHashMap::new, // LinkedHashMap preserves insertion order
                Collectors.toList()
            ));
}
}