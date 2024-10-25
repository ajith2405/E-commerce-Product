package com.example.demo.service;

import com.example.demo.entity.Customer;

import java.util.List;


public interface CustomerServiceInterface {
     List<Customer> getAllCustomers();
     Customer saveCustomer(Customer customer);
     void deleteCustomerByCustomerId(Long customerId);
}
