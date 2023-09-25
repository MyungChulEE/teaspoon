package com.teaspoon.teamall.domain.product.vo;

import lombok.*;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductVO {
    private int productNo;
    private int prodCateNo;
    private String productName;
    private String productContent;
    private int productPrice;
    private int productCnt;
}
