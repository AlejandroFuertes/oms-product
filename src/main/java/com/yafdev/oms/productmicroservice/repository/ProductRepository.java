package com.yafdev.oms.productmicroservice.repository;

import com.yafdev.oms.productmicroservice.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, Long> {

}
