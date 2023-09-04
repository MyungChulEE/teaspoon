package com.teaspoon.teamall.domain.cart.service;

import com.teaspoon.teamall.domain.cart.dto.CartDTO;

import java.util.List;

public interface CartService {
    List<CartDTO> getCartList();

    void cartInsert();
    void cartUpdate();
    void cartDelete();

}
