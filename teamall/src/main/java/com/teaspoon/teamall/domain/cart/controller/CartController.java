package com.teaspoon.teamall.domain.cart.controller;


import com.teaspoon.teamall.domain.cart.dto.CartRequestDTO;
import com.teaspoon.teamall.domain.cart.dto.CartResponseDTO;
import com.teaspoon.teamall.domain.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping("/items")
    public ResponseEntity<Map<String, String>> addCart(@RequestBody CartRequestDTO cartRequestDTO) {
        System.out.println("cartRequestDTO.toString() = " + cartRequestDTO.toString());
        int cartItem = cartService.createCartItem(cartRequestDTO);
        System.out.println("cartItem = " + cartItem);
        Map<String, String> response = new HashMap<>();
        response.put("status", "ok");
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/items")
    public String getCartItems(Model model) {
        List<CartResponseDTO> cartItems = cartService.getCartItems();
        int totalPrice = cartItems.stream().mapToInt(CartResponseDTO::getTotalPrice).sum();
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("totalPrice", totalPrice);
        return "/order/cart";
    }

    @PostMapping("/modify")
    public String modifyCartItemAmount(@ModelAttribute CartRequestDTO.ListDTO cartRequestDTO) {
        cartRequestDTO.getList().forEach(System.out::println);
        int cartItemAmount = cartService.modifyCartItemAmount(cartRequestDTO);
        System.out.println("cartItemAmount = " + cartItemAmount);

        return "redirect:/cart/items";
    }


    @DeleteMapping("/{no}")
    public ResponseEntity<String> removeCartItem(@PathVariable int no) {

        int removedCartItem = cartService.removeCartItem(no);
        if (removedCartItem != 0) {
            return ResponseEntity.ok().body("ok");
        }
        return ResponseEntity.badRequest().body("fail");
    }

}
