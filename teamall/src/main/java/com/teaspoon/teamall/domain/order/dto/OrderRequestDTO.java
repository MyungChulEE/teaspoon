package com.teaspoon.teamall.domain.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO {

    private int productNo;
    @NotBlank
    @Min(value = 1)
    private int orderAmount;
    @NotBlank
    private int orderPrice;

    @Data
    @NoArgsConstructor
    public static class ListDTO {
        private List<OrderRequestDTO> list;
    }
}
