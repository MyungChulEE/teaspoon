package com.teaspoon.teamall.domain.order.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderProductRequestDTO {

    private int productNo;
    @Min(value = 1)
    @NotBlank
    private int orderAmount;

    @Data
    @NoArgsConstructor
    public static class ListDTO {
        private List<OrderProductRequestDTO> list;
    }
}
