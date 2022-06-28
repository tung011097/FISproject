package com.example.testfinal.service.impl;

import com.example.testfinal.model.Product;
import com.example.testfinal.repository.ProductRepository;
import com.example.testfinal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product findById(Long productId) {
        return productRepository.findById(productId).get();
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }
}
