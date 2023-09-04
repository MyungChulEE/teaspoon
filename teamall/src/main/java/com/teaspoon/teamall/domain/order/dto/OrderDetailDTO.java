package com.teaspoon.teamall.domain.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDTO {

    private int orderNo;
    private String productName;
    private int productPrice;
    private int orderAmount;
    private int orderPrice;

}
