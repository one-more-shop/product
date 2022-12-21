package com.onemoreshot.product.mapper;

import org.springframework.stereotype.Component;

import com.onemoreshot.product.dto.ProductDTO;
import com.onemoreshot.product.model.Product;

@Component
public class ProductDtoToProductMapper {

    public Product convert(ProductDTO productDTO) {
        Product product = Product.builder()
                .id(productDTO.getId())
                .seller(productDTO.getSeller())
                .name(productDTO.getName())
                .description(productDTO.getDescription())
                .price(productDTO.getPrice())
                .inCart(productDTO.getInCart())
                .addedInCartDateTime(productDTO.getAddedInCartDateTime())
                .build();

        return product;
    }

}
