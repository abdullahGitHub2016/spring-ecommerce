package com.free_source.spring_ecommerce.controller;

import com.free_source.spring_ecommerce.model.CartItem;
import com.free_source.spring_ecommerce.repository.CartRepository;
import com.free_source.spring_ecommerce.service.ProductService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartRepository cartRepository;
    private final ProductService productService;

    @PostMapping("/add")
    public String addToCart(@RequestParam Long productId, @RequestParam Integer quantity, HttpSession session) {
        CartItem item = new CartItem();
        item.setProduct(productService.getProductById(productId));
        item.setQuantity(quantity);
        item.setSessionId(session.getId());

        cartRepository.save(item);
        return "redirect:/cart";
    }

    @GetMapping
    public String viewCart(Model model, HttpSession session) {
        model.addAttribute("cartItems", cartRepository.findBySessionId(session.getId()));
        model.addAttribute("content", "cart :: content");
        return "layout";
    }
}