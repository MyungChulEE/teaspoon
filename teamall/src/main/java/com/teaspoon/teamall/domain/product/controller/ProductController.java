package com.teaspoon.teamall.domain.product.controller;

import com.teaspoon.teamall.domain.product.dto.ProductDTO;
import com.teaspoon.teamall.domain.product.dto.ProductRequestDTO;
import com.teaspoon.teamall.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/list")
    public String productList(Model model){
        List<ProductDTO> productList = productService.getProductList();
        model.addAttribute("productList", productList);
        return "product/productlist.html";
    }

    @GetMapping("/regist")
    public String productRegist(Model model){
        model.addAttribute("ProductRequestDTO", new ProductRequestDTO());
        return "product/productRegist.html";

    }

    @PostMapping("/regist")
    public String productRegistOk(@ModelAttribute ProductRequestDTO productRequestDTO){
        productService.productRegist(productRequestDTO);
        return "product/productRegistOk.html";
    }


    @GetMapping("/update/{productNo}")
    public String productUpdate(@PathVariable("productNo") int productNo, Model model){
        model.addAttribute("ProductRequestDTO", new ProductRequestDTO());
        ProductDTO productDTO = productService.getProductDetail(productNo);
        model.addAttribute("productDTO", productDTO);
        return "product/productupdate.html";
    }

    @PostMapping("/update/{productNo}")
    public String productUpdate(@PathVariable("productNo") int productNo, @ModelAttribute ProductRequestDTO productRequestDTO, Model model) {
        productService.productUpdate(productRequestDTO, productNo);
        ProductDTO productDTO = productService.getProductDetail(productNo);
        model.addAttribute("productDTO", productDTO);
        return "product/productupdateok.html";
    }

    @GetMapping("/{productNo}")
    public String productDetail(@PathVariable("productNo") int productNo, Model model){
        ProductDTO productDTO = productService.getProductDetail(productNo);
        model.addAttribute("productDTO", productDTO);
        return "product/productdetail.html";
    }

    @GetMapping("/detail")
    public String productForm(){

        return "product/shop-detail";
    }

    @GetMapping("/cart")
    public String productCart(){

        return "/order/cart";
    }

}
