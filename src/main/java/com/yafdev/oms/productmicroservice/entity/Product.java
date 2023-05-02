package com.yafdev.oms.productmicroservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "product")
public class Product {

    @Id
    private String id;
    private String sku;
    private String companyCode;
    private String description;
    private String barcode;
    private BigDecimal unitCost;
    private Date productLife;
}