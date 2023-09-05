package com.teaspoon.teamall.domain.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;


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
