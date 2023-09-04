package com.teaspoon.teamall.domain.cart.service;

import com.teaspoon.teamall.domain.cart.dto.CartDTO;
import com.teaspoon.teamall.domain.cart.mapper.CartMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{
    private final CartMapper cartMapper;
    @Override
    public List<CartDTO> getCartList() {
        return null;
    }

    @Override
    public void cartInsert() {

    }

    @Override
    public void cartUpdate() {

    }

    @Override
    public void cartDelete() {

    }
}
