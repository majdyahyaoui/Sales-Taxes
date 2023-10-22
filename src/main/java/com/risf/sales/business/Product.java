package com.risf.sales.business;

import com.risf.sales.utils.MathUtils;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@Setter
@SuperBuilder
public abstract class Product {

    protected static final BigDecimal BASIC_RATE = new BigDecimal("0.1");
    protected static final BigDecimal IMPORTED_RATE = new BigDecimal("0.05");

    String name;
    BigDecimal priceHT;
    boolean isBook;
    boolean isFood;
    boolean isMedicalProduct;
    boolean isImported;
    BigDecimal priceTTC;

    abstract BigDecimal getRate();

    protected boolean isExempt() {
        return isFood() || isBook() || isMedicalProduct();
    }

    public void computePriceTTC() {
        setPriceTTC(getTax().add(getPriceHT()));
    }

    public BigDecimal getTax() {
        return MathUtils.roundToNearest_0_05(getRate().multiply(getPriceHT()));
    }
}
