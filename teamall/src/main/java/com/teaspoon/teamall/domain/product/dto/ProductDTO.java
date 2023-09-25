package com.teaspoon.teamall.domain.product.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private int productNo;
    private String productCategory;
    private int prodCatePk;
    private String productName;
    private String productContent;
    private int productPrice;
    private int productCnt;




}
