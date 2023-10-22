package com.risf.sales.dto;

import com.risf.sales.business.BasicProduct;
import com.risf.sales.business.ImportedProduct;
import com.risf.sales.business.Product;

import java.math.BigDecimal;

public record ProductInput(
        String name,
        boolean isFood,
        boolean isBook,
        boolean isMedical,
        boolean isImported,
        BigDecimal priceHT
) {
    public Product toProduct(){
        if (isImported) {
            return ImportedProduct.builder()
                    .name(name)
                    .priceHT(priceHT)
                    .isFood(isFood)
                    .isBook(isBook)
                    .isMedicalProduct(isMedical)
                    .isImported(true)
                    .build();
        }
        return BasicProduct.builder()
                .name(name)
                .priceHT(priceHT)
                .isFood(isFood)
                .isBook(isBook)
                .isMedicalProduct(isMedical)
                .isImported(false)
                .build();
    }
}
