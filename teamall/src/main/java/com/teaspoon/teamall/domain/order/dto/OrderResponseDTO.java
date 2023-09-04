package com.teaspoon.teamall.domain.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDTO {

    private int orderNo;
    private LocalDateTime orderTime;
    private int orderAmount;
    private int orderStatus;
    private int orderPrice;
    private String orderCode;
    private String productName;
}
