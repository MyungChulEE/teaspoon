package com.teaspoon.teamall.domain.product.controller;

import com.teaspoon.teamall.domain.product.dto.ProductDTO;
import com.teaspoon.teamall.domain.product.mapper.ProductMapper;
import com.teaspoon.teamall.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductSearchController {
    private final ProductService productService;

//    @GetMapping("/search")
//    public String searchProduct(@RequestParam String searchType,@RequestParam String searchWord, Model model){
//        List<productDTO> productList = productService.searchProductList(searchType, searchWord);
//        model.addAttribute("productList", productList);
//        return "/product/productList";
//
//    }

//    public String productList(Model model){
//        List<ProductDTO> productList = productService.getProductList();
//        model.addAttribute("productList", productList);
//        return "product/productlist.html";

}
