package com.ordersservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String productId;

    private Integer qty;

    private Integer unitPrice;

    private Integer totalPrice;

    private String userId;

    private String orderId;

    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    private Date createdAt;


    @Builder
    public OrderEntity(Long id, String productId, Integer qty, Integer unitPrice, Integer totalPrice, String userId, String orderId, Date createdAt) {
        this.id = id;
        this.productId = productId;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.userId = userId;
        this.orderId = orderId;
        this.createdAt = createdAt;
    }
}
