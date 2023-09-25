package com.teaspoon.teamall.domain.product.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString
@Builder
public class ProductRequestDTO {
    private int category1;
    private int category2;
    private int category3;
    private String productName;
    private String productContent;
    private int productPrice;

}
