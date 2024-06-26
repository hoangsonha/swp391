package com.group6.swp391.response;

import com.group6.swp391.enums.EnumGenderName;
import com.group6.swp391.model.OrderDetail;
import com.group6.swp391.model.Payment;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class OrderDetailRespone {
    private int orderId;
    private int quantity;
    private String fullName;
    private String addressShipping;
    private String phoneShipping;
    private List<Payment> payments;
    private LocalDateTime orderDate;
    private List<OrderDetail> orderDetails;
    private double price;
    private String status;
    private String reason;
    private boolean deleteStatus;
    private String note;
    private String email;
    private double discount;
    private EnumGenderName gender;
}
