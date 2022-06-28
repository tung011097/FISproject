package com.example.testfinal.service;

import com.example.testfinal.dto.CustomerDTO;
import com.example.testfinal.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    Page<CustomerDTO> findAllCustomer(Pageable pageable);
    Customer findByIdCustomer(Long customerId);
    Page<CustomerDTO> createdCustomer(CustomerDTO customerDTO, Pageable pageable);
    CustomerDTO updateByIdCustomer(Long customerId,CustomerDTO customerDTO);
    void deleteByIdCustomer(Long customerId);
}
