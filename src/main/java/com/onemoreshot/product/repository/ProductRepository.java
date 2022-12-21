package com.onemoreshot.product.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.onemoreshot.product.model.Product;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
    
}
