package com.onemoreshot.product.service;

import org.springframework.stereotype.Service;

import com.onemoreshot.product.dto.ProductDTO;
import com.onemoreshot.product.mapper.ProductDtoToProductMapper;
import com.onemoreshot.product.model.Product;
import com.onemoreshot.product.repository.ProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private ProductDtoToProductMapper mapper;

    public ProductService(final ProductRepository productRepository,
            final ProductDtoToProductMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    public Flux<Product> findAll() {
        return this.productRepository.findAll();
    }

    public Mono<Product> findById(final String id) {
        return this.productRepository.findById(id);
    }

    public Mono<Product> create(final ProductDTO productDTO) {
        Product product = mapper.convert(productDTO);

        return this.productRepository.save(product);
    }

    public Mono<Product> update(final String id, final ProductDTO productDTO) {
        Product product = mapper.convert(productDTO);

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
