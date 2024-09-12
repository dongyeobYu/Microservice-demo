package com.catalogsservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "catalog")
public class CatalogEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String productId;

    private String productName;

    private Integer stock;

    private Integer unitPrice;

    private Date createdAt;


}
