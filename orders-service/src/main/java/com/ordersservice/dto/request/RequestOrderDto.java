package com.ordersservice.dto.request;

import lombok.Data;

@Data
public class RequestOrderDto {

    private String productId;

    private Integer qty;

    private Integer unitPrice;

    private Integer totalPrice;

    private String orderId;

    private String userId;
}
