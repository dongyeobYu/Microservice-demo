package com.catalogsservice.dto;

import com.catalogsservice.entity.CatalogEntity;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
public class ResponseCatalogDto {

    private String productId;
    private String productName;
    private Integer stock;
    private Integer unitPrice;
    private Date createdAt;

    @Builder
    public ResponseCatalogDto(String productId, String productName, Integer stock, Integer unitPrice, Date createdAt) {
        this.productId = productId;
        this.productName = productName;
        this.stock = stock;
        this.unitPrice = unitPrice;
        this.createdAt = createdAt;
    }



    public ResponseCatalogDto(CatalogEntity catalog) {
        this.productId = catalog.getProductId();
        this.productName = catalog.getProductName();
        this.stock = catalog.getStock();
        this.unitPrice = catalog.getUnitPrice();
        this.createdAt = catalog.getCreatedAt();
    }


}
