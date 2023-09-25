package com.teaspoon.teamall.domain.order.mapper;

import com.teaspoon.teamall.domain.order.dto.OrderDetailDTO;
import com.teaspoon.teamall.domain.order.dto.OrderResponseDTO;
import com.teaspoon.teamall.domain.order.vo.OrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface OrderMapper {


    int insertOrder(OrderVO orders);

    int getTotalOrder();

    List<OrderResponseDTO> getOrderList(@Param("memberNo") int memberNo,
                                        @Param("pageSize") int pageSize,
                                        @Param("offset") int offset);

    List<OrderDetailDTO> getOrder(String orderCode);

    int updateOrder(OrderVO order);

    int deleteOrder(String orderCode);

    int deleteOrderItem(int orderNo);
}
