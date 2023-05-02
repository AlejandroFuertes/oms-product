package com.yafdev.oms.productmicroservice.converter;

import com.yafdev.oms.productmicroservice.dto.ProductDTO;
import com.yafdev.oms.productmicroservice.entity.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ProductConverter {

    public ProductDTO productEntityToDTO(Product entity) {
        ProductDTO productDTO = ProductDTO.builder()
                .sku(entity.getSku())
                .companyCode(entity.getCompanyCode())
                .description(entity.getDescription())
                .barcode(entity.getBarcode())
                .unitCost(entity.getUnitCost().toString())
                .productLife(parseDateToString(entity.getProductLife()))
                .build();
        return productDTO;
    }

    public Product productDtoToEntity(ProductDTO dto) {
        Product product = Product.builder()
                .sku(dto.getSku())
                .companyCode(dto.getCompanyCode())
                .description(dto.getDescription())
                .barcode(dto.getBarcode())
                .unitCost(parseStringToBigDecimal(dto.getUnitCost()))
                .productLife(parseStringToDate(dto.getProductLife()))
                .build();
        return product;
    }

    private BigDecimal parseStringToBigDecimal(String unitCost) {

        try {
            BigDecimal bigDecimal = new BigDecimal(unitCost);
            return bigDecimal;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String parseDateToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dateString = sdf.format(date);
        return dateString;
    }

    private Date parseStringToDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date aux = null;
        try {
            aux = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return aux;
    }

}
