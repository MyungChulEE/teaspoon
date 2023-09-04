package com.teaspoon.teamall.domain.order.controller;


import com.teaspoon.teamall.domain.order.dto.*;
import com.teaspoon.teamall.domain.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/page")
    public String findOrderList(@RequestParam(value = "no", defaultValue = "1") int no, Model model) {
        int pageSize = 10;
        int totalOrder = orderService.getTotalOrder();

        int memberNo = 1;
        List<OrderResponseDTO> orderList = orderService.findOrderList(memberNo, no, pageSize);
        orderList.stream().forEach(System.out::println);
        model.addAttribute("orders", orderList);
        model.addAttribute("currentPage", no);
        model.addAttribute("totalPages", (int) Math.ceil((double) totalOrder / pageSize));

        return "/order/orderlist";
    }

    @GetMapping("/{code}")
    public String getOrderDetail(@PathVariable("code") String code, Model model) {

        List<OrderDetailDTO> orderDetail = orderService.findOrderDetail(code);
        orderDetail.stream().forEach(System.out::println);
        int totalPrice = orderDetail.stream().mapToInt(OrderDetailDTO::getOrderPrice).sum();
        model.addAttribute("order", orderDetail);
        model.addAttribute("totalPrice", totalPrice);
        return "/order/order-detail";
    }

    @GetMapping("/confirm")
    public String confirmOrder(Model model, @ModelAttribute OrderProductRequestDTO orderProductRequestDTO) {
        OrderProductResponseDTO orderProductResponseDTO = orderService.confirmOrder(orderProductRequestDTO);
        System.out.println("orderProductResponseDTO.toString() = " + orderProductResponseDTO.toString());
        int totalPrice = orderProductResponseDTO.getOrderPrice();
        System.out.println("totalPrice = " + totalPrice);
        model.addAttribute("orderProductList", orderProductResponseDTO);
        model.addAttribute("totalPrice", totalPrice);

        return "/order/checkout";
    }

    @PostMapping("/confirm")
    public String confirmOrder(Model model, @ModelAttribute OrderProductRequestDTO.ListDTO orderProductRequestDTO) {
        System.out.println("orderProductRequestDTO = " + orderProductRequestDTO);
        List<OrderProductResponseDTO> orderProductResponseDTO = orderService.confirmOrder(orderProductRequestDTO);
        System.out.println("orderProductResponseDTO.toString() = " + orderProductResponseDTO.toString());
        int totalPrice = orderProductResponseDTO.stream()
                .mapToInt(OrderProductResponseDTO::getOrderPrice)
                .sum();
        System.out.println("totalPrice = " + totalPrice);
        model.addAttribute("orderProductList", orderProductResponseDTO);
        model.addAttribute("totalPrice", totalPrice);

        return "/order/checkout";
    }

    @GetMapping("/cart")
    public String orderCart() {
        return "order/cart";
    }


    @PostMapping()
    public String createOrder(@ModelAttribute OrderRequestDTO.ListDTO orderRequestDTO) {
        String email = "test@email.com";
        orderRequestDTO.getList().forEach(System.out::println);

        int order = orderService.createOrder(orderRequestDTO, email);
        System.out.println("order = " + order);
        return "redirect:/";
    }

    @GetMapping("/modify/{code}")
    public String UpdateOrderDetail(@PathVariable("code") String code, Model model) {

        List<OrderDetailDTO> orderDetail = orderService.findOrderDetail(code);
        orderDetail.stream().forEach(System.out::println);
        int totalPrice = orderDetail.stream().mapToInt(OrderDetailDTO::getOrderPrice).sum();
        boolean updateFlag = true;
        model.addAttribute("isUpdateMode", updateFlag);
        model.addAttribute("order", orderDetail);
        model.addAttribute("totalPrice", totalPrice);
        return "/order/order-detail";
    }

    @PatchMapping("/modify/{no}")
    public String modifyOrder(@PathVariable("no") int no,
                              @ModelAttribute OrderRequestDTO orderRequestDTO) {

        int modifyOrder = orderService.modifyOrder(no, orderRequestDTO);
        System.out.println("modifyOrder = " + modifyOrder);
        return "/index";
    }

    @DeleteMapping("/item/{no}")
    public ResponseEntity<String> removeOrder(@PathVariable("no") int no) {

        int removeOrder = orderService.removeOrderOne(no);
        System.out.println("removeOrder = " + removeOrder);

        if (removeOrder == 0) {
            return ResponseEntity.badRequest().body("failed");
        }
        return ResponseEntity.ok("success");
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<String> removeOrder(@PathVariable("code") String orderCode) {

        int removeOrder = orderService.removeOrder(orderCode);
        System.out.println("removeOrder = " + removeOrder);

        if (removeOrder == 0) {
            return ResponseEntity.badRequest().body("failed");
        }
        return ResponseEntity.ok("success");
    }

}
