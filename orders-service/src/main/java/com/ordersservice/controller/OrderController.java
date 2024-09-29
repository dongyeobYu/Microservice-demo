package com.ordersservice.controller;

import com.ordersservice.dto.request.RequestOrderDto;
import com.ordersservice.dto.response.ResponseOrderDto;
import com.ordersservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-service")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;


    @GetMapping("/health_check")
    public String status(){
        return "ok";
    }

    @PostMapping("/{userId}/orders/")
    public ResponseEntity<ResponseOrderDto> createOrder(@PathVariable("userId") String userId, @RequestBody RequestOrderDto requestOrderDto){
        return ResponseEntity.ok().body(orderService.createOrder(userId, requestOrderDto));
    }

    @GetMapping("/{userId}/orders")
    public ResponseEntity<List<ResponseOrderDto>> getOrders(@PathVariable("userId") String userId){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrderByUserId(userId));
    }

}
