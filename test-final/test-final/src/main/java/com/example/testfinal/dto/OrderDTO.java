package com.example.testfinal.dto;

import com.example.testfinal.model.Order;
import com.example.testfinal.model.OrderItem;
import com.example.testfinal.model.OrderStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {
    private Long id;
    private LocalDateTime orderDateTime;
    private Long customerId;
    private List<OrderItem> orderItems;
    private Double totalAmount;
    private OrderStatus status;
    public static class Mapper{
        public static OrderDTO fromEntity(Order order){
            return OrderDTO.builder().id(order.getId())
                    .orderItems(order.getOrderItems())
                    .customerId(order.getCustomer().getId())
                    .totalAmount(order.getTotalAmount())
                    .status(order.getStatus())
                    .build();
        }
    }
}
