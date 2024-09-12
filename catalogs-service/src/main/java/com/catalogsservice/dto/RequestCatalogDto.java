package com.catalogsservice.dto;

import lombok.Data;

@Data
public class RequestCatalogDto {

    private String productId;

    private Integer qty;

    private Integer unitPrice;

    private Integer totalPrice;

    private String orderId;

    private String userId;
}
