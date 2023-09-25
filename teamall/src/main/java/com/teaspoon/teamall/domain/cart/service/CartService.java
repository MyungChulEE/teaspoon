package com.teaspoon.teamall.domain.cart.service;

import com.teaspoon.teamall.domain.cart.dto.CartRequestDTO;
import com.teaspoon.teamall.domain.cart.dto.CartResponseDTO;

import java.util.List;

public interface CartService {

    int createCartItem(CartRequestDTO cartRequestDTO);

    List<CartResponseDTO> getCartItems();

    int modifyCartItemAmount(CartRequestDTO.ListDTO cartRequestDTO);

    int removeCartItem(int cartNo);
}
