package vn.fis.training.ordermanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fis.training.ordermanagement.domain.Customer;
import vn.fis.training.ordermanagement.domain.Order;
import vn.fis.training.ordermanagement.domain.OrderItem;
import vn.fis.training.ordermanagement.domain.OrderStatus;
import vn.fis.training.ordermanagement.repository.OrderRepository;
import vn.fis.training.ordermanagement.service.OrderService;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order) {
        orderRepository.save(order);
        return order;
    }

    @Override
    public Order addOrderItem(Long orderID,OrderItem orderItem) {
        Optional<Order> order = orderRepository.findById(orderID);
        order.get().getOrderItems().add(orderItem);
        return order.get();
    }

    @Override
    public Order removeOrderItem(Long orderID,OrderItem orderItem) {
        Optional<Order> order = orderRepository.findById(orderID);
        order.get().getOrderItems().remove(orderItem);
        return order.get();
    }

    @Override
    public Order updateOrderStatus(Order order,OrderStatus orderStatus) {
        order.setStatus(orderStatus);
        orderRepository.save(order);
        return order;
    }

    @Override
    public List<Order> findOrdersBetween(LocalDateTime fromDateTime, LocalDateTime toDateTime) {
        return orderRepository.findOrdersBetween(fromDateTime,toDateTime);
    }

    @Override
    public List<Order> findWaitingApprovalOrders() {
        return null;
    }

    @Override
    public List<Order> findOrdersByOrderStatus(OrderStatus orderStatus) {
        return Collections.emptyList();
    }

    @Override
    public List<Order> findOrdersByCustomer(Customer customer) {
        return orderRepository.findOrdersByCustomer(customer);
    }
}
