package com.teaspoon.teamall.domain.cart.service;

import com.teaspoon.teamall.domain.cart.dto.CartItemDTO;
import com.teaspoon.teamall.domain.cart.dto.CartRequestDTO;
import com.teaspoon.teamall.domain.cart.dto.CartResponseDTO;
import com.teaspoon.teamall.domain.cart.mapper.CartMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartMapper cartMapper;

    @Override
    @Transactional
    public int createCartItem(CartRequestDTO cartRequestDTO) {
        int memberNo = 1;
        int productNo = cartRequestDTO.getProductNo();
        CartItemDTO cartItem = cartMapper.selectCartItem(memberNo, productNo);
        if (cartItem == null) {
            return cartMapper.insertCart(memberNo, cartRequestDTO);
        }
        return cartMapper.updateCartAmount(memberNo, cartRequestDTO);
    }

    @Override
    public List<CartResponseDTO> getCartItems() {
        int memberNo = 1;
        List<CartResponseDTO> cartResponseDTO = cartMapper.selectCartItemAll(memberNo);
        cartResponseDTO.stream()
                .forEach(dto -> dto.setTotalPrice(dto.getCartAmount() * dto.getProductPrice()));
        return cartResponseDTO;
    }

    @Override
    public int modifyCartItemAmount(CartRequestDTO.ListDTO cartRequestDTO) {
        System.out.println("cartRequestDTO.toString() = " + cartRequestDTO.toString());
        int memberNo = 1;
        int cnt = 0;
        for (CartRequestDTO cartItem : cartRequestDTO.getList()) {
            cnt += cartMapper.updateCartItemAmount(memberNo, cartItem);
        }
        return cnt;
    }

    @Override
    public int removeCartItem(int cartNo) {
        return cartMapper.deleteCartItem(cartNo);
    }
}
