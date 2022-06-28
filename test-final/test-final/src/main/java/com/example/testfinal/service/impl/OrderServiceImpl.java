package com.example.testfinal.service.impl;

import com.example.testfinal.dto.AddOrderIteamDTO;
import com.example.testfinal.dto.CreatedOrderDTO;
import com.example.testfinal.dto.OrderDTO;
import com.example.testfinal.dto.RemoveOrderItemDTO;
import com.example.testfinal.model.*;
import com.example.testfinal.repository.OrderItemRepository;
import com.example.testfinal.repository.OrderRepository;
import com.example.testfinal.service.CustomerService;
import com.example.testfinal.service.OrderService;
import com.example.testfinal.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {


    private OrderRepository orderRepository;
    private CustomerService customerService;
    private ProductService productService;
    private OrderItemRepository orderItemRepository;

    public OrderServiceImpl(OrderRepository orderRepository, CustomerService customerService,
                            ProductService productService, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.customerService = customerService;
        this.productService = productService;
        this.orderItemRepository = orderItemRepository;
    }


    @Override
    public Page<OrderDTO> findAll(Pageable pageable) {
        log.info("Query all order, Page Number : {}, Page Size", pageable.getPageNumber(),pageable.getPageSize());
        return orderRepository.findAll(pageable).map(OrderDTO.Mapper::fromEntity);
    }

    @Override
    public Order findById(Long orderId) {
        Order orderFindById = orderRepository.findById(orderId).get();
        log.info("Order : {}", orderFindById);
        return orderFindById;
    }

    @Override
    public Order create(CreatedOrderDTO createdOrderDTO) {
        List<OrderItem> orderItemList = new ArrayList<>();
        Customer customer = customerService.findByIdCustomer(createdOrderDTO.getCustomerId());
        createdOrderDTO.getOrderItemInfo().forEach(productQuantityDTO ->{
            Product product = productService.findById(productQuantityDTO.getProductId());
            OrderItem orderItem = OrderItem.builder()
                    .product(product)
                    .quantity(productQuantityDTO.getQuantity())
                    .amount(product.getPrice() * productQuantityDTO.getQuantity())
                    .build();
        } );
        Order order = Order.builder()
                .orderDateTime(LocalDateTime.now())
                .status(OrderStatus.CREATED)
                .customer(customer)
                .orderItems(orderItemList)
                .totalAmount(orderItemList.stream().mapToDouble(OrderItem::getQuantity).sum())
                .build();
        orderRepository.save(order);
        return order;
    }

    @Override
    public void delete(Long orderId) {
        Order order = findById(orderId);
        if (OrderStatus.CREATED.equals(order.getStatus()) || OrderStatus.CANCELLED.equals(order.getStatus())) {
            try{
                throw new Exception("Can not delete Order has status id CREATED || CANCELLED");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        orderRepository.deleteById(orderId);
    }
    @Override
    public Order addOrderItem(AddOrderIteamDTO addOrderIteamDTO) {
        Order order = findById(addOrderIteamDTO.getOrderId());
        Product product = productService.findById(addOrderIteamDTO.getProductId());
        if(order == null){
            try{
                throw new Exception("Not found order with id");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if(!OrderStatus.CREATED.equals(order.getStatus())){
            try{
                throw new Exception("Status Not CREATED");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        OrderItem orderItem = OrderItem.builder()
                .amount(product.getPrice() * addOrderIteamDTO.getQuantity())
                .quantity(addOrderIteamDTO.getQuantity())
                .order(order)
                .product(product)
                .build();
        order.setTotalAmount(order.getTotalAmount() + orderItem.getAmount());
        order.getOrderItems().add(orderItem);
        orderRepository.save(order);
        product.setAvaiable(product.getAvaiable() - addOrderIteamDTO.getQuantity());
        productService.update(product);
        return findById(addOrderIteamDTO.getOrderId());
    }

    @Override
    public Order removeOrderItem(RemoveOrderItemDTO removeOrderItemDTO) {
        Order order = findById(removeOrderItemDTO.getOrderId());
        if(order == null){
            try{
                throw new Exception("Not found order with id");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if(!OrderStatus.CREATED.equals(order.getStatus())){
            try{
                throw new Exception("Status Not CREATED");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        orderItemRepository.deleteById(removeOrderItemDTO.getOrderItemId());
        return findById(removeOrderItemDTO.getOrderId());

    }
}
