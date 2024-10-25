package com.example.demo.repo;

import com.example.demo.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo  extends JpaRepository<OrderEntity, Long> {
}
