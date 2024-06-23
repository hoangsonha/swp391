package com.group6.swp391.response;


import lombok.*;

import java.util.List;

@Setter
@Getter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewOrderRespone {
    private int userId;
    private List<OrderRespone> orders;
}
