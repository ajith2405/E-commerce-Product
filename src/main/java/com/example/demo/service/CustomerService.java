package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerService implements CustomerServiceInterface{
    @Autowired
    private CustomerRepository customerRepository;
    public Optional<Customer> getCustomerByCustomerId(Long customerId){
        return customerRepository.findById(customerId);
    }
    @Override
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    @Override
    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }
    @Override
    public void deleteCustomerByCustomerId(Long customerId){
         customerRepository.deleteById(customerId);
    }

}
