package com.onemoreshop.product.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    
    @Id
    private String id;

    private String seller;

    private String name;

    private String description;

    private BigDecimal price;

    private Boolean inCart;

    private LocalDateTime addedInCartDateTime;
}
