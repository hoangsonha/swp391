package com.group6.swp391.service;

import com.group6.swp391.model.Order;
import com.group6.swp391.model.OrderDetail;
import com.group6.swp391.model.Payment;
import com.group6.swp391.repository.OrderDetailRepository;
import com.group6.swp391.repository.OrderRepository;
import com.group6.swp391.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImp implements OrderService {

    @Autowired private OrderRepository orderRepository;

    @Autowired private OrderDetailRepository orderDetailRepository;
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderByOrderID(int orderID) {
        return orderRepository.getOrderByOrderID(orderID);
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public void markOrderAsDeleted(int orderID) {
        try {
            Order order = getOrderByOrderID(orderID);
            if (order != null) {
                order.setDeleteStatus(false);
                orderRepository.save(order);
            } else {
                throw new RuntimeException("Order not found with id: " + orderID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createOrderDetails(List<OrderDetail> orderDetails) {
        orderDetailRepository.saveAll(orderDetails);
    }

    @Override
    public List<Order> getOrderByDiamondID(String diamondID) {
        List<OrderDetail> orderDetails = orderDetailRepository.findByDiamondDiamondID(diamondID);
        List<Order> orders = new ArrayList<>();
        for (OrderDetail detail : orderDetails) {
            if (!orders.contains((detail.getOrder()))) {
                orders.add(detail.getOrder());
            }
        }
        return orders;
    }

    @Override
    public Order saveOrder(Order order, List<OrderDetail> orderDetails, List<Payment> payments) {
        try {
            Order savedOrder = orderRepository.save(order);
            for (OrderDetail detail :  orderDetails) {
                detail.setOrder(savedOrder);
            }
            orderDetailRepository.saveAll(orderDetails);

            for (Payment payment : payments) {
                payment.setOrder(savedOrder);
            }
            paymentRepository.saveAll(payments);

            savedOrder.setOrderDetails(orderDetails);
            savedOrder.setPayments(payments);

            return savedOrder;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
