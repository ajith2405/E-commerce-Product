package com.example.demo.service;

import com.example.demo.entity.OrderItem;
import com.example.demo.repo.OrderItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {
    @Autowired
    private OrderItemRepo orderItemRepository;

    public OrderItem addOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public OrderItem updateOrderItem(Long id, OrderItem orderItem) {
        return orderItemRepository.findById(id)
                .map(existingOrderItem -> {
                    existingOrderItem.setOrder(orderItem.getOrder());
                    existingOrderItem.setProduct(orderItem.getProduct());
                    existingOrderItem.setQuantity(orderItem.getQuantity());
                    return orderItemRepository.save(existingOrderItem);
                }).orElseThrow(() -> new RuntimeException("OrderItem not found"));
    }

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public Optional<OrderItem> getOrderItemById(Long id) {
        return orderItemRepository.findById(id);
    }

    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }
}
