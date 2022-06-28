package com.example.testfinal.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {
    OrderServiceImpl orderService;
    @Test
    void findAll() {
        Pageable pageable = PageRequest.of(1,10);
        System.out.println(orderService.findAll(pageable));
    }
}