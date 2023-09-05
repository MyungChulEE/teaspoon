package com.teaspoon.teamall.domain.cart.mapper;

import com.teaspoon.teamall.domain.cart.dto.CartItemDTO;
import com.teaspoon.teamall.domain.cart.dto.CartRequestDTO;
import com.teaspoon.teamall.domain.cart.dto.CartResponseDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CartMapper {

    int insertCart(@Param("memberNo") int memberNo, @Param("cartRequestDTO") CartRequestDTO cartRequestDTO);

    CartItemDTO selectCartItem(@Param("memberNo") int memberNo, @Param("productNo") int productNo);

    List<CartResponseDTO> selectCartItemAll(int memberNo);

    int updateCartAmount(@Param("memberNo") int memberNo, @Param("cartRequestDTO") CartRequestDTO cartRequestDTO);

    int updateCartItemAmount(@Param("memberNo") int memberNo, @Param("cartRequestDTO") CartRequestDTO cartRequestDTO);

    int deleteCartItem(int cartNo);

    int deleteCheckoutItem(@Param("memberNo") int memberNo,@Param("productNo") int productNo);

    int clearCart(int memberNo);
}
