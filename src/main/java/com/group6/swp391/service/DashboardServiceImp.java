package com.group6.swp391.service;

import com.group6.swp391.model.Order;
import com.group6.swp391.repository.OrderDetailRepository;
import com.group6.swp391.repository.OrderRepository;
import com.group6.swp391.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardServiceImp implements DashboardService {
    @Autowired OrderRepository orderRepository;
    @Autowired OrderDetailRepository orderDetailRepository;
    @Autowired UserRepository userRepository;


    @Override
    public List<Order> totalRevenueStore() {
        return orderRepository.findByStatus("Đã giao");
    }

    @Override
    public Double getTotalRevenueInMonth(int month, int year) {
        Double revenue = orderRepository.findTotalRevenueInMonth(month, year);
        return (revenue != null) ? revenue : 0.0;
    }

    @Override
    public Double getTotalRevenueDiamond(int month, int year) {
        Double revenue = orderDetailRepository.findTotalDiamondRevenueInMonth(month, year);
        return (revenue != null) ? revenue : 0.0;
    }

    @Override
    public Double getTotalRevenueProductcustomizer(int month, int year) {
        Double revenue = orderDetailRepository.findTotalProductCustomizeRevenueInMonth(month, year);
        return (revenue != null) ? revenue : 0.0;
    }

    @Override
    public List<Order> getOrderByStatus(int month, String status) {
        return orderRepository.findByStatusMonth(month, status);
    }

    @Override
    public Integer newUser(int month, int year) {
        return userRepository.newuser(month, year);
    }

    @Override
    public Double totalRevenueDate(int date, int month, int year) {
        return orderRepository.totalRevenueInDate(date, month, year);
    }
}
