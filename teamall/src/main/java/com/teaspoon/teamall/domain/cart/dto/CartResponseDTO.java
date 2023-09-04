package com.teaspoon.teamall.domain.cart.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartResponseDTO {

    private int cartNo;
    private int cartAmount;
    private int productNo;
    private String productName;
    private int productPrice;
    private int totalPrice;
}
