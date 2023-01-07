package com.onemoreshop.product.service;

import org.springframework.stereotype.Service;

import com.onemoreshop.product.converter.ProductDtoToProductConverter;
import com.onemoreshop.product.dto.ProductDTO;
import com.onemoreshop.product.model.Product;
import com.onemoreshop.product.repository.ProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private ProductDtoToProductConverter converter;

    public ProductService(final ProductRepository productRepository,
            final ProductDtoToProductConverter mapper) {
        this.productRepository = productRepository;
        this.converter = mapper;
    }

    public Flux<Product> findAll() {
        return this.productRepository.findAll();
    }

    public Mono<Product> findById(final String id) {
        return this.productRepository.findById(id);
    }

    public Mono<Product> create(final ProductDTO productDTO) {
        Product product = converter.convert(productDTO);

        return this.productRepository.save(product);
    }

    public Mono<Product> update(final String id, final ProductDTO productDTO) {
        Product product = converter.convert(productDTO);

        return this.productRepository.findById(id)
                .flatMap(p -> {
                    product.setId(id);
                    return this.productRepository.save(product);
                })
                .switchIfEmpty(Mono.empty());
    }

    public Mono<Void> delete(final String id) {

        return this.productRepository.deleteById(id);
    }

}
