package com.example.testfinal.controller;

import com.example.testfinal.dto.AddOrderIteamDTO;
import com.example.testfinal.dto.CreatedOrderDTO;
import com.example.testfinal.dto.OrderDTO;
import com.example.testfinal.dto.RemoveOrderItemDTO;
import com.example.testfinal.model.Order;
import com.example.testfinal.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/{pageNumber}/{pageSize}")
    public Page<OrderDTO> findAll(@PathVariable("pageNumber") Integer pageNumber,
                                  @PathVariable("pageSize") Integer pageSize) {
        log.info("Response All Order. PageNumber: {}, PageSize: {}", pageNumber, pageSize);
        return orderService.findAll(PageRequest.of(pageNumber, pageSize));
    }
    @GetMapping("/{orderId")
    public ResponseEntity<Order> findById(@PathVariable("orderId") Long orderId){
        Order order = orderService.findById(orderId);
        log.info("Order With id {} : {}", orderId, order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<Order> create(@RequestBody CreatedOrderDTO createdOrderDTO) {
        Order order = orderService.create(createdOrderDTO);
        log.info("Saved Order: {}", order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<String> delete(@PathVariable("orderId") Long orderId) {
        orderService.delete(orderId);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PostMapping("/addOrderItem")
    public Order addOrderItem(@RequestBody AddOrderIteamDTO addOrderItemDTO) {
        Order order = orderService.addOrderItem(addOrderItemDTO);
        log.info("Order (Added new OrderItem): {}", order);
        return order;
    }

    @PostMapping("/removeOrderItem")
    public Order removeOrderItem(@RequestBody RemoveOrderItemDTO removeItemDTO) {
        Order order = orderService.removeOrderItem(removeItemDTO);
        log.info("OrderItem Removed: {}", order);
        return order;
    }

    @PostMapping("/paid/{orderId}")
    public OrderDTO paid(@PathVariable("orderId") Long orderId) {
        return null;
    }

    @PostMapping("/cancel/{orderId}")
    public OrderDTO cancel(@PathVariable("orderId") Long orderId) {
        return null;
    }
}
