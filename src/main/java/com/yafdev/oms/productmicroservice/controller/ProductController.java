package com.yafdev.oms.productmicroservice.controller;

import com.yafdev.oms.productmicroservice.dto.ProductDTO;
import com.yafdev.oms.productmicroservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/oms/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/list")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO getProductBySku(@RequestParam String sku) {
        return productService.getProductBySku(sku);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductDTO productDTO) {
        productService.createProduct(productDTO);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO updateProduct(ProductDTO productDTO) {
        productService.updateProduct(productDTO);
        return null;
    }

    @DeleteMapping("/delete/{sku}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@RequestParam String sku) {
        productService.deleteProduct(sku);
    }

    @DeleteMapping("/delete/all")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllProducts() {
        productService.deleteAll();
    }
}
