package com.free_source.spring_ecommerce.controller;

import com.free_source.spring_ecommerce.model.Product;
import com.free_source.spring_ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ProductService productService;

    @GetMapping("/")
    public String index(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);

        // This MUST be the exact filename 'index' and fragment 'content'
        model.addAttribute("content", "index :: content");

        return "layout";
    }

    @GetMapping("/product/{id}")
    public String showProduct(@PathVariable Long id, Model model) {
        // 1. Fetch the specific product
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);

        // 2. Tell the layout to load 'details.html'
        model.addAttribute("content", "details :: content");

        return "layout";
    }
}