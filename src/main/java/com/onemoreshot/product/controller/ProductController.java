package com.onemoreshot.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onemoreshot.product.dto.ProductDTO;
import com.onemoreshot.product.model.Product;
import com.onemoreshot.product.service.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Flux<Product> findAll() {

        return this.productService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Product> findById(@PathVariable String id) {

        return this.productService.findById(id);
    }

    @PostMapping
    public Mono<Product> create(@RequestBody ProductDTO productDTO) {

        return this.productService.create(productDTO);
    }

    @PutMapping("/{id}")
    public Mono<Product> update(@PathVariable String id, @RequestBody ProductDTO productDTO) {

        return this.productService.update(id, productDTO);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {

        return this.productService.delete(id);
    }

}
