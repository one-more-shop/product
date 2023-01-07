package com.onemoreshop.product.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ProductDTO {
    
    private String id;

    private String seller;

    private String name;

    private String description;

    private BigDecimal price;

    private Boolean inCart;

    private LocalDateTime addedInCartDateTime;
}
