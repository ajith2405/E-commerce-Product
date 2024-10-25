package com.example.demo.service;

import com.example.demo.entity.OrderEntity;
import com.example.demo.entity.Product;
import com.example.demo.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepository;

    public OrderEntity addOrder(OrderEntity order) {
        return orderRepository.save(order);
    }

    public OrderEntity updateOrder(Long id, OrderEntity order) {
        return orderRepository.findById(id)
                .map(existingOrder -> {
                    existingOrder.setCustomer(order.getCustomer());
                    existingOrder.setCustomer(order.getCustomer());
                    existingOrder.setStatus(order.getStatus());
                    return orderRepository.save(existingOrder);
                }).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<OrderEntity> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
