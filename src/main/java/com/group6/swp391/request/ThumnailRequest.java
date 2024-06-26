package com.group6.swp391.request;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ThumnailRequest {
    private String ojectId;
    private String imageUrl;
}
