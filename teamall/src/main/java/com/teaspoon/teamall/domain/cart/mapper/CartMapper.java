package com.teaspoon.teamall.domain.cart.mapper;

import com.teaspoon.teamall.domain.cart.dto.CartDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {
    List<CartDTO> getCartList();
    void cartInsert();
    void cartUpdate();
    void cartDelete();
}
