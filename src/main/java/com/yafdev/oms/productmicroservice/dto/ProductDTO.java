package com.yafdev.oms.productmicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private String sku;
    private String companyCode;
    private String description;
    private String barcode;
    private String unitCost;
    private String productLife;
}
