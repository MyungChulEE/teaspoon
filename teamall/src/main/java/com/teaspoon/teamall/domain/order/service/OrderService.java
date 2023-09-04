package com.teaspoon.teamall.domain.order.service;

import com.teaspoon.teamall.domain.order.dto.*;

import java.util.List;

public interface OrderService {


    int createOrder(OrderRequestDTO.ListDTO orderRequestDTO, String email);

    List<OrderResponseDTO> findOrderList(int memberNo, int pageSize, int offset);


    int getTotalOrder();

    OrderProductResponseDTO confirmOrder(OrderProductRequestDTO orderProductRequestDTO);

    List<OrderProductResponseDTO> confirmOrder(OrderProductRequestDTO.ListDTO orderProductRequestDTO);

    List<OrderDetailDTO> findOrderDetail(String orderCode);

    int modifyOrder(int no, OrderRequestDTO orderRequestDTO);

    int removeOrderOne(int no);

    int removeOrder(String orderCode);
}
