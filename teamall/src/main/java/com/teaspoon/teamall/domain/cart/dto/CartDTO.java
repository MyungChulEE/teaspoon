package com.teaspoon.teamall.domain.cart.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {
    private int cartNo;
    private int memberNo;
    private int productNo;
    private int cartAmount;
}
