package com.risf.sales.business;

import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@SuperBuilder
public class ImportedProduct extends Product {
    @Override
    BigDecimal getRate() {
        return IMPORTED_RATE.add(isExempt() ? BigDecimal.ZERO : BASIC_RATE);
    }
}
