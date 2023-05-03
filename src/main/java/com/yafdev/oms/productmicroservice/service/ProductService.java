package com.yafdev.oms.productmicroservice.service;

import com.yafdev.oms.productmicroservice.dto.ProductDTO;
import com.yafdev.oms.productmicroservice.entity.Product;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getAllProducts();
    void createProduct(ProductDTO productDTO);
    ProductDTO getProductBySku(String sku);
    ProductDTO updateProduct(ProductDTO productDTO);
    void deleteProduct(String sku);
    void deleteAll();
}
