package com.risf.sales.business;

import lombok.experimental.SuperBuilder;
import java.math.BigDecimal;

@SuperBuilder
public class BasicProduct extends Product {
    @Override
    BigDecimal getRate() {
        return isExempt() ? BigDecimal.ZERO : BASIC_RATE;
    }
}
