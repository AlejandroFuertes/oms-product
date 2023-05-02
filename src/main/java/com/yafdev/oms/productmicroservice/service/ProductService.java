package com.yafdev.oms.productmicroservice.service;

import com.yafdev.oms.productmicroservice.dto.ProductDTO;
import com.yafdev.oms.productmicroservice.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    void createProduct(ProductDTO productDTO);
    Product getProductBySku(String sku);
}
