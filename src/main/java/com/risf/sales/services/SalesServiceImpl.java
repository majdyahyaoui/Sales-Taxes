package com.risf.sales.services;

import com.risf.sales.business.Product;
import com.risf.sales.dto.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class SalesServiceImpl implements SalesService {
    @Override
    public ReceiptDetails computeReceiptDetails(List<ProductLineInput> productLines) {
        BigDecimal totalTax = BigDecimal.ZERO;
        BigDecimal totalTTC = BigDecimal.ZERO;
        ArrayList<ProductLineOutput> productLineOutputs = new ArrayList<>();

        for (ProductLineInput productLine : productLines) {
            Product product = productLine.productInput().toProduct();
            product.computePriceTTC();
            ProductLineOutput productLineOutput = new ProductLineOutput(
                    productLine.quantity(),new ProductOutput(product));
            productLineOutputs.add(productLineOutput);
            totalTax = totalTax.add(product.getTax());
            totalTTC = totalTTC.add(product.getPriceTTC().multiply(
                    BigDecimal.valueOf(productLineOutput.quantity())));
        }

        return new ReceiptDetails(productLineOutputs, totalTax, totalTTC);
    }
}
