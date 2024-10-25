package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product addproduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

   public Product updateProduct(Long id, Product product) throws Exception{
        return productRepository.findById(id)
                .map(ex -> {
            ex.setName(product.getName());
            ex.setCategory(product.getCategory());
            ex.setPrice(product.getPrice());
            ex.setDescription(product.getDescription());
            return ex;
        }).orElseThrow(()-> new RuntimeException("no product found"));
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}
