package com.group6.swp391.request;

import com.group6.swp391.enums.EnumGenderName;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderRequest {
    String addressShipping;
    String fullName;
    LocalDateTime orderDate;
    String phoneShipping;
    double price;
    String status;
    int quantity;
    int userID;
    double usedPoint;
    String reason;
    String note;
    String email;
    EnumGenderName gender;
    List<OrderDetailRequest> orderDetail;
}
