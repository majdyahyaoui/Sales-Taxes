package com.risf.sales.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathUtils {
    public static BigDecimal roundToNearest_0_05(BigDecimal f){
        BigDecimal increment = new BigDecimal("0.05");
        return f.divide(increment, 0, RoundingMode.CEILING).multiply(increment);
    }
}
