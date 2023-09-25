package com.teaspoon.teamall.domain.cart.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartRequestDTO {

    private int cartNo;
    @NotBlank
    private int productNo;
    @NotBlank
    @Min(value = 1)
    private int cartAmount;


    @Data
    @NoArgsConstructor
    public static class ListDTO{
        private List<CartRequestDTO> list;
    }
}
