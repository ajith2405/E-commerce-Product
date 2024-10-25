package com.example.demo.repo;

import com.example.demo.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepo  extends JpaRepository<OrderItem, Long> {
}
