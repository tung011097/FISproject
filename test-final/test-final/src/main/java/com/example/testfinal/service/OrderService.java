package com.example.testfinal.service;

import com.example.testfinal.dto.AddOrderIteamDTO;
import com.example.testfinal.dto.CreatedOrderDTO;
import com.example.testfinal.dto.OrderDTO;
import com.example.testfinal.dto.RemoveOrderItemDTO;
import com.example.testfinal.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {
    Page<OrderDTO> findAll(Pageable pageable);
    Order findById(Long orderId);
    Order create(CreatedOrderDTO createdOrderDTO);
    void delete(Long orderId);
    Order addOrderItem(AddOrderIteamDTO addOrderIteamDTO);

    Order removeOrderItem(RemoveOrderItemDTO removeOrderItemDTO);
}
