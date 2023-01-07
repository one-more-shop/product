package com.onemoreshop.product.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.onemoreshop.product.dto.ProductDTO;
import com.onemoreshop.product.model.Product;

@Component
public class ProductDtoToProductConverter implements Converter<ProductDTO, Product> {

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
