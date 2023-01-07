package com.onemoreshop.product.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.onemoreshop.product.model.Product;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
    
}
