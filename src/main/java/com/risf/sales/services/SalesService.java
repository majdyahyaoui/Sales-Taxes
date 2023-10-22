package com.risf.sales.services;

import com.risf.sales.dto.ProductLineInput;
import com.risf.sales.dto.ReceiptDetails;

import java.util.List;

public interface SalesService {
    ReceiptDetails computeReceiptDetails(List<ProductLineInput> productLines);
}
