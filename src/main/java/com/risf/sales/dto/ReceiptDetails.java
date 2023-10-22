package com.risf.sales.dto;

import java.math.BigDecimal;
import java.util.List;

public record ReceiptDetails(
        List<ProductLineOutput> productLineOutputList,
        BigDecimal totalTaxes,
        BigDecimal totalTTC
) {
}
