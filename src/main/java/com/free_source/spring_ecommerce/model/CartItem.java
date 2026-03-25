package com.free_source.spring_ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cart_items")
@Data
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private com.free_source.spring_ecommerce.model.Product product;

    private Integer quantity;

    // For now, we use a session ID or User ID to link the cart
    private String sessionId;
}