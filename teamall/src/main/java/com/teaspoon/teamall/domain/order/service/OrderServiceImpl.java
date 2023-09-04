package com.teaspoon.teamall.domain.order.service;

import com.teaspoon.teamall.domain.cart.mapper.CartMapper;
import com.teaspoon.teamall.domain.member.dto.MemberProfileDTO;
import com.teaspoon.teamall.domain.member.mapper.MemberMapper;
import com.teaspoon.teamall.domain.order.dto.*;
import com.teaspoon.teamall.domain.order.mapper.OrderMapper;
import com.teaspoon.teamall.domain.order.vo.OrderVO;
import com.teaspoon.teamall.domain.product.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;
    private final MemberMapper memberMapper;
    private final ProductMapper productMapper;
    private final CartMapper cartMapper;

    @Transactional
    @Override
    public int createOrder(OrderRequestDTO.ListDTO orderRequestDTO, String email) {
        MemberProfileDTO member = memberMapper.findByProfile(email);
        cartMapper.clearCart(member.getMemberNo());

        String orderCode = UUID.randomUUID().toString().replace("-", "");
        return orderRequestDTO.getList().stream()
                .map(orderRequest -> OrderVO.builder()
                        .productNo(orderRequest.getProductNo())
                        .memberNo(member.getMemberNo())
                        .orderAmount(orderRequest.getOrderAmount())
                        .orderPrice(orderRequest.getOrderPrice())
                        .orderStatus(1)
                        .orderCode(orderCode)
                        .build())
                .mapToInt(orderMapper::insertOrder)
                .sum();
    }

    @Override
    public List<OrderResponseDTO> findOrderList(int memberNo, int page, int pageSize) {
        int offset = (page - 1) * pageSize;
        return orderMapper.getOrderList(memberNo, pageSize, offset);
    }

    public int getTotalOrder() {
        return orderMapper.getTotalOrder();
    }

    @Transactional(readOnly = true)
    @Override
    public OrderProductResponseDTO confirmOrder(OrderProductRequestDTO orderProductRequestDTO) {
        OrderProductResponseDTO orderProductResponse = productMapper.findProductNo(orderProductRequestDTO.getProductNo());
        orderProductResponse.setProductNo(orderProductRequestDTO.getProductNo());
        orderProductResponse.setOrderAmount(orderProductRequestDTO.getOrderAmount());
        orderProductResponse.setOrderPrice(orderProductResponse.getProductPrice() * orderProductResponse.getOrderAmount());
        return orderProductResponse;
    }

    @Transactional(readOnly = true)
    @Override
    public List<OrderProductResponseDTO> confirmOrder(OrderProductRequestDTO.ListDTO orderProductRequestDTO) {
        List<OrderProductResponseDTO> orderProductResponseDTO = new ArrayList<>();

        for (OrderProductRequestDTO orderProduct : orderProductRequestDTO.getList()) {
            OrderProductResponseDTO orderProductResponse = productMapper.findProductNo(orderProduct.getProductNo());
            orderProductResponse.setProductNo(orderProduct.getProductNo());
            orderProductResponse.setOrderAmount(orderProduct.getOrderAmount());
            orderProductResponse.setOrderPrice(orderProductResponse.getProductPrice() * orderProduct.getOrderAmount());
            orderProductResponseDTO.add(orderProductResponse);
        }
        return orderProductResponseDTO;
    }

    @Override
    public List<OrderDetailDTO> findOrderDetail(String orderCode) {

        return orderMapper.getOrder(orderCode);
    }


    @Transactional
    @Override
    public int modifyOrder(int no, OrderRequestDTO orderRequestDTO) {


        return orderMapper.updateOrder(OrderVO.builder()
                .orderNo(no)
                .productNo(orderRequestDTO.getProductNo())
                .orderAmount(orderRequestDTO.getOrderAmount())
                .build());
    }

    @Transactional
    @Override
    public int removeOrderOne(int no) {

        return orderMapper.deleteOrderItem(no);
    }

    @Transactional
    @Override
    public int removeOrder(String orderCode) {

        return orderMapper.deleteOrder(orderCode);
    }
}
