/*
package com.free_source.spring_ecommerce.model;

import com.free_source.spring_ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        if (productRepository.count() == 0) {
            Product laptop = new Product();
            laptop.setName("Acer Swift Go 14 OLED");
            laptop.setPrice(749.99);
            laptop.setImageUrl("https://m.media-amazon.com/images/I/71jG+e7roXL._AC_SL1500_.jpg");
            laptop.setCategory("Laptops");
            laptop.setDescription("Premium OLED laptop for professionals.");

            // Fix: Wrap Arrays.asList in HashSet
            laptop.setFeatures(new HashSet<>(Arrays.asList(
                "14\" WQXGA+ OLED Display",
                "Intel Core Ultra 7 Processor",
                "16GB LPDDR5X RAM"
            )));

            // Using helper methods for Specs and Variants
            laptop.addSpecification(new ProductSpecification(null, "Processor", "Model", "Intel Ultra 7", laptop));
            laptop.addSpecification(new ProductSpecification(null, "Display", "Panel", "OLED", laptop));

            laptop.addVariant(new ProductVariant(null, "512GB SSD", 749.99, "AC-512", 10, laptop));
            laptop.addVariant(new ProductVariant(null, "1TB SSD", 849.99, "AC-1TB", 5, laptop));

            productRepository.save(laptop);
            System.out.println(">> Database Seeded Successfully!");
        }
    }
} */
