package com.teaspoon.teamall.domain.order.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderProductRequestDTO {

    private int productNo;
    private int orderAmount;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ListDTO {
        private List<OrderProductRequestDTO> list;
    }
}
