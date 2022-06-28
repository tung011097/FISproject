package com.example.testfinal.service;

import com.example.testfinal.model.Product;

public interface ProductService {
    Product findById(Long productId);
    Product update(Product product);
}
