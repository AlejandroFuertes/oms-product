package com.yafdev.oms.productmicroservice.service.impl;

import com.yafdev.oms.productmicroservice.converter.ProductConverter;
import com.yafdev.oms.productmicroservice.dto.ProductDTO;
import com.yafdev.oms.productmicroservice.entity.Product;
import com.yafdev.oms.productmicroservice.repository.ProductRepository;
import com.yafdev.oms.productmicroservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductConverter converter;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void createProduct(ProductDTO productDTO) {
        Product product = converter.productDtoToEntity(productDTO);
        productRepository.save(product);
    }

    @Override
    public Product getProductBySku(String sku) {
        return null;
    }
}
