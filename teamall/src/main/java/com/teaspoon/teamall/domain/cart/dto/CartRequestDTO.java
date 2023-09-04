package com.teaspoon.teamall.domain.cart.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartRequestDTO {

    private int cartNo;
    private int productNo;
    private int cartAmount;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ListDTO{
        private List<CartRequestDTO> list;
    }
}
