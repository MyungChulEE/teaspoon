package com.teaspoon.teamall.domain.product.controller;

import com.teaspoon.teamall.domain.product.mapper.ProductMapper;
import com.teaspoon.teamall.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductSearchController {
    private final ProductService productService;

    @GetMapping("/search")
    public String searchProduct(@RequestParam String searchType,@RequestParam String searchWord){
        productService.searchProductList(searchType, searchWord);
        return "/product/productList";

    };

}
