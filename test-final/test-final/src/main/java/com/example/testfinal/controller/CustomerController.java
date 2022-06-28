package com.example.testfinal.controller;

import com.example.testfinal.dto.CustomerDTO;
import com.example.testfinal.model.Customer;
import com.example.testfinal.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@Slf4j
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/{pageNumber}/{pageSize}")
    public Page<CustomerDTO> findAll(@PathVariable(name = "pageNumber") Integer pageNumber
            , @PathVariable(name = "pageSize") Integer pageSize) {
        log.info("All Customer. PageNumber: {}, PageSize: {}", pageNumber, pageSize);
        return customerService.findAllCustomer(PageRequest.of(pageNumber, pageSize));
    }
    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> findById(@PathVariable(name = "customerId") Long customerId) {
        Customer customer = customerService.findByIdCustomer(customerId);
        CustomerDTO customerDTO = CustomerDTO.MapperCustomer.fromEntity(customer);
        log.info("Customer find by id: {}", customerDTO);
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    @PostMapping("/{pageNumber}/{pageSize}")
    public Page<CustomerDTO> create(@RequestBody CustomerDTO customerDTO,
                                    @PathVariable(name = "pageNumber") Integer pageNumber
            , @PathVariable(name = "pageSize") Integer pageSize) {
        Page<CustomerDTO> customerDTOPage = customerService.createdCustomer(customerDTO, PageRequest.of(pageNumber, pageSize));
        return customerDTOPage;
    }
    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> update(@PathVariable("customerId") Long customerId,
                                              @RequestBody CustomerDTO customerDTO) {
        CustomerDTO updatedCustomer = customerService.updateByIdCustomer(customerId, customerDTO);
        log.info("Updated customer: {}", updatedCustomer);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }
    @DeleteMapping("/{customerId}")
    public ResponseEntity<String> delete(@PathVariable("customerId") Long customerId) {
        customerService.deleteByIdCustomer(customerId);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}

