package com.free_source.spring_ecommerce.repository;

import com.free_source.spring_ecommerce.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CartRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findBySessionId(String sessionId);
    void deleteBySessionId(String sessionId);
}