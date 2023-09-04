package com.teaspoon.teamall.domain.cart.controller;

import com.teaspoon.teamall.domain.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping("/")
    public String cartAdd(){
        return "/cart/cartadd.html";
    }




}
