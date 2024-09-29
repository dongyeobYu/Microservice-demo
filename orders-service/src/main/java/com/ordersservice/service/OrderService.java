package com.ordersservice.service;

import com.ordersservice.dto.request.RequestOrderDto;
import com.ordersservice.dto.response.ResponseOrderDto;
import com.ordersservice.entity.OrderEntity;
import com.ordersservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional
    public ResponseOrderDto createOrder(String userId, RequestOrderDto requestOrderDto) {
        OrderEntity orderEntity = OrderEntity.builder()
                .qty(requestOrderDto.getQty())
                .userId(userId)
                .orderId(requestOrderDto.getOrderId())
                .unitPrice(requestOrderDto.getUnitPrice())
                .totalPrice(requestOrderDto.getTotalPrice())
                .createdAt(new Date())
                .build();

        orderRepository.save(orderEntity);

        return ResponseOrderDto.builder()
                .productId(orderEntity.getProductId())
                .orderId(orderEntity.getOrderId())
                .qty(orderEntity.getQty())
                .unitPrice(orderEntity.getUnitPrice())
                .totalPrice(orderEntity.getTotalPrice())
                .build();
    }

    @Transactional(readOnly = true)
    public ResponseOrderDto getOrderByOrderId(String orderId) {

        OrderEntity order = orderRepository.findByOrderId(orderId).orElseThrow(() -> new RuntimeException("Order not found"));

        return ResponseOrderDto.builder()
                .productId(order.getProductId())
                .orderId(order.getOrderId())
                .qty(order.getQty())
                .unitPrice(order.getUnitPrice())
                .totalPrice(order.getTotalPrice())
                .build();
    }

    @Transactional(readOnly = true)
    public List<ResponseOrderDto> getOrderByUserId(String userId) {
        return orderRepository.findByUserId(userId).stream().map(ResponseOrderDto::new).collect(Collectors.toList());
    }


}
