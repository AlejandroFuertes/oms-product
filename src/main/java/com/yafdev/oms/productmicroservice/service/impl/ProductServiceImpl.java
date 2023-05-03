package com.yafdev.oms.productmicroservice.service.impl;

import com.yafdev.oms.productmicroservice.converter.ProductConverter;
import com.yafdev.oms.productmicroservice.dto.ProductDTO;
import com.yafdev.oms.productmicroservice.entity.Product;
import com.yafdev.oms.productmicroservice.repository.ProductRepository;
import com.yafdev.oms.productmicroservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductConverter converter;

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        if(products.isEmpty()) {
            throw new RuntimeException("Lista de productos vacia");
        }
        return formatResponse(products);
    }

    @Override
    public void createProduct(ProductDTO productDTO) {
        Product product = converter.productDtoToEntity(productDTO);
        productRepository.save(product);
    }

    @Override
    public ProductDTO getProductBySku(String sku) {
        Optional<Product> product = productRepository.findBySku(sku);
        Product productFound = product.orElseThrow(()-> new RuntimeException("El optional esta vacio"));
        //Product productFound = productRepository.findBySku(sku);
        ProductDTO productDTO = converter.productEntityToDTO(productFound);

        return productDTO;
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) {

        Product product = null;
        return null;
    }

    private List<ProductDTO> formatResponse(List<Product> products) {
        List<ProductDTO> productsDTO = new ArrayList<>();
        for (Product product: products) {
            ProductDTO productDTO = converter.productEntityToDTO(product);
            productsDTO.add(productDTO);
        }
        return productsDTO;
    }
}
