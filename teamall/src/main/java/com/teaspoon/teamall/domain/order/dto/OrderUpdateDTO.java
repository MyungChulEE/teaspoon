package com.teaspoon.teamall.domain.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderUpdateDTO {

    private int orderNo;
    private int orderAmount;
    private int orderPrice;
}
