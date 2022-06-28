package com.example.testfinal.service.impl;

import com.example.testfinal.dto.CustomerDTO;
import com.example.testfinal.model.Customer;
import com.example.testfinal.repository.CustomerRepository;
import com.example.testfinal.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Page<CustomerDTO> findAllCustomer(Pageable pageable) {
        log.info("Query all customer, Page Number {}, Page Size {}",pageable.getPageNumber(),pageable.getPageSize());
        return customerRepository.findAll(pageable).map(CustomerDTO.MapperCustomer::fromEntity);
    }

    @Override
    public Customer findByIdCustomer(Long customerId) {
        Customer customerFindById = customerRepository.findById(customerId).get();
        return customerFindById;
    }

    @Override
    public Page<CustomerDTO> createdCustomer(CustomerDTO customerDTO, Pageable pageable) {
        Customer customer = Customer.builder()
                .name(customerDTO.getName())
                .mobile(customerDTO.getMobile())
                .address(customerDTO.getAddress())
                .build();
        customerRepository.save(customer);
        log.info("Saved Customer : {}", customer);
        return findAllCustomer(pageable);
    }

    @Override
    public CustomerDTO updateByIdCustomer(Long customerId,CustomerDTO customerDTO) {
        Customer customer = customerRepository.findById(customerId).get();
        customer.setAddress(customerDTO.getAddress());
        customer.setMobile(customerDTO.getMobile());
        Customer updateCustomer = customerRepository.save(customer);
        log.info("Customer update : {}", updateCustomer);
        return CustomerDTO.MapperCustomer.fromEntity(updateCustomer);
    }

    @Override
    public void deleteByIdCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }
}
