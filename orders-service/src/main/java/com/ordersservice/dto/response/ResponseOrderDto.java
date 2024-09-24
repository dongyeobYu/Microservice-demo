package com.ordersservice.dto.response;

import com.ordersservice.entity.OrderEntity;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
public class ResponseOrderDto {

    private String productId;

    private Integer qty;

    private Integer unitPrice;

    private Integer totalPrice;

    private Date createAt;

    private String orderId;

    public ResponseOrderDto() {
    }

    @Builder
    public ResponseOrderDto(String productId, Integer qty, Integer unitPrice, Integer totalPrice, Date createAt, String orderId) {
        this.productId = productId;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.createAt = createAt;
        this.orderId = orderId;
    }

    public ResponseOrderDto(OrderEntity orderEntity) {
    }
}
