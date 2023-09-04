package com.teaspoon.teamall.domain.order.vo;

import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class OrderVO {

    private int orderNo;
    private int productNo;
    private int memberNo;
    private LocalDate orderTime;
    private int orderAmount;
    private int orderStatus;
    private int orderPrice;
    private String orderCode;


}
