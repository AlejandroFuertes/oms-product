package com.yafdev.oms.productmicroservice.service.impl;

import com.yafdev.oms.productmicroservice.converter.ProductConverter;
import com.yafdev.oms.productmicroservice.dto.ProductDTO;
import com.yafdev.oms.productmicroservice.entity.Product;
import com.yafdev.oms.productmicroservice.exception.ProductNotFoundException;
import com.yafdev.oms.productmicroservice.repository.ProductRepository;
import com.yafdev.oms.productmicroservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private static final Logger log = LogManager.getLogger(ProductServiceImpl.class);
    private static final String PRODUCT_NOT_FOUND = "Product not found";
    private static final String EMPTY_LIST = "No products in the database";

    private final ProductRepository productRepository;
    private final ProductConverter converter;

    @Override
    public List<ProductDTO> getAllProducts() {
        log.info("Entry to service get all products.");
        List<Product> products = productRepository.findAll();
        if (products.isEmpty()) {
            throw new ProductNotFoundException(EMPTY_LIST);
        }
        return formatResponse(products);
    }

    @Override
    public void createProduct(ProductDTO productDTO) {
        log.info("Entry to service create product.");
        Product product = converter.productDtoToEntity(productDTO);
        productRepository.save(product);
    }

    @Override
    public ProductDTO getProductBySku(String sku) {
        log.info("Entry to service get product by sku.");
        return converter.productEntityToDTO(findProductBySKU(sku));
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) {
        log.info("Entry to service update product.");
        Product productFound = findProductBySKU(productDTO.getSku());
        log.info("Product: " + productFound.toString());
        productRepository.save(productFound);
        log.info("Updated product");
        return converter.productEntityToDTO(productFound);
    }

    @Override
    public void deleteProduct(String sku) {
        log.info("Entry to service delete product.");
        Product productFound = findProductBySKU(sku);
        log.info("Product: " + productFound.toString());
        productRepository.delete(productFound);
    }

    public void deleteAll() {
        log.info("Entry to service delete all.");
        productRepository.deleteAll();
        log.info("Empty database");
    }

    private List<ProductDTO> formatResponse(List<Product> products) {
        List<ProductDTO> productsDTO = new ArrayList<>();
        for (Product product: products) {
            ProductDTO productDTO = converter.productEntityToDTO(product);
            productsDTO.add(productDTO);
        }
        return productsDTO;
    }

    private Product findProductBySKU(String sku) {
        Optional<Product> product = productRepository.findBySku(sku);
        return product.orElseThrow(()-> new ProductNotFoundException(PRODUCT_NOT_FOUND));
    }
}
