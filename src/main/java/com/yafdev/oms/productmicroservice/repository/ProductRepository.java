package com.yafdev.oms.productmicroservice.repository;

import com.yafdev.oms.productmicroservice.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, Long> {
    Optional<Product> findBySku(String sku);
}
