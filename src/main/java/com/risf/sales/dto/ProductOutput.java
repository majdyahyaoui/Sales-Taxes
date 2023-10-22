package com.risf.sales.dto;

import com.risf.sales.business.Product;

import java.math.BigDecimal;

public record ProductOutput(
        String name,
        boolean isImported,
        BigDecimal priceTTC
) {
    public ProductOutput(Product product){
        this(product.getName(), product.isImported(), product.getPriceTTC());
    }
}
