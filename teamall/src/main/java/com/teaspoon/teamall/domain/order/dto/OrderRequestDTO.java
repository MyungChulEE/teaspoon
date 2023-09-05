package com.teaspoon.teamall.domain.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO {

    private int productNo;
    private int orderAmount;
    private int orderPrice;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ListDTO {
        private List<OrderRequestDTO> list;
    }
}
