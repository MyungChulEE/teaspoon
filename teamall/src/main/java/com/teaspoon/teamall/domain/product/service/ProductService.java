package com.teaspoon.teamall.domain.product.service;

import com.teaspoon.teamall.domain.product.dto.ProductDTO;
import com.teaspoon.teamall.domain.product.dto.ProductRequestDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getProductList();
    ProductDTO getProductDetail(int productNo);
    void productRegist(ProductRequestDTO productRequestDTO);
    List<ProductDTO> searchProductList(String searchType, String searchWord);

    void productUpdate(ProductRequestDTO productRequestDTO, int productNo);
    void productDelete(ProductDTO productDTO);
}
