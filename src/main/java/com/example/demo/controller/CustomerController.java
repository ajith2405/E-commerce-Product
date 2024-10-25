package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.entity.OrderEntity;
import com.example.demo.service.CustomerService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class CustomerController extends BaseController {
    @Autowired
    private CustomerService customerService;
    Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @GetMapping("/getCustomerInfo")
    public ResponseEntity<Customer> getCustomer(Long CustomerId){
        Optional<Customer> customer = customerService.getCustomerByCustomerId(CustomerId);
        return customer.map(value -> new ResponseEntity<>(value, HttpStatus.FOUND)).
                orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
    @GetMapping("getAllCustomers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return ResponseEntity.of(Optional.ofNullable(customerService.getAllCustomers()));
    }
    @PostMapping("saveCustomer")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
       return ResponseEntity.of(Optional.ofNullable(customerService.saveCustomer(customer)));
    }
    @DeleteMapping ("/deleteCustomerInfo")
    public ResponseEntity<String> deleteCustomer(Long CustomerId){
        try {
            customerService.deleteCustomerByCustomerId(CustomerId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("processing error during customer delete action for customer id"+CustomerId);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("updateCustomer")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        Optional<Customer> customer1 = customerService.getCustomerByCustomerId(customer.getId());
        if (customer1.isPresent()) {
            return ResponseEntity.of(Optional.ofNullable(customerService.saveCustomer(customer)));
        } else {
            logger.error("user doesnt exisit for user id"+ customer.getId());
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
