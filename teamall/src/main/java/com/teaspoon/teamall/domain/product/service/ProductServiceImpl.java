package com.teaspoon.teamall.domain.product.service;

import com.teaspoon.teamall.domain.product.dto.ProductDTO;
import com.teaspoon.teamall.domain.product.dto.ProductRequestDTO;
import com.teaspoon.teamall.domain.product.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductMapper productMapper;

    @Override
    public List<ProductDTO> getProductList() {
        return productMapper.getProductList();
    }

    @Override
    public ProductDTO getProductDetail(int productNo) {
        return productMapper.getProductDetail(productNo);
    }


    @Override
    public List<ProductDTO> searchProductList(String searchType, String searchWord) {
        List<ProductDTO> productList = productMapper.searchProduct(searchType, searchWord);
        System.out.println(searchType);
        System.out.println(searchWord);
        System.out.println(productList.size());
        for (ProductDTO a : productList) {
            System.out.println(a);
        }
        return productList;
    }

    @Override
    public void productRegist(ProductRequestDTO productRequestDTO) {
        Integer cateNo = productMapper.getCateNo(productRequestDTO);
        String categoryCode = productRequestDTO.getCategory1() + "," + productRequestDTO.getCategory2() + "," + productRequestDTO.getCategory3();
        ProductDTO productDTO = ProductDTO.builder()
                .productCategory(categoryCode)
                 .productName(productRequestDTO.getProductName())
                .productContent(productRequestDTO.getProductContent())
                .productPrice(productRequestDTO.getProductPrice())
                .build();
        productMapper.productRegist(productDTO);
    }

    @Override
    public void productUpdate(ProductRequestDTO productRequestDTO, int productNo) {
        ProductDTO productDTO = ProductDTO.builder()
                .productNo(productNo)
                .productCategory(productRequestDTO.getCategory1() + "," + productRequestDTO.getCategory2() + "," +productRequestDTO.getCategory3())
                .productName(productRequestDTO.getProductName())
                .productContent(productRequestDTO.getProductContent())
                .productPrice(productRequestDTO.getProductPrice())
                .build();

        productMapper.productUpdate(productDTO);
    }
    @Override
    public void productDelete(ProductDTO productDTO) {
        productMapper.productDelete(productDTO);
    }



}
