package com.risf.sales.controllers;

import com.risf.sales.dto.ProductLineInput;
import com.risf.sales.dto.ReceiptDetails;
import com.risf.sales.services.SalesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/sales")
@AllArgsConstructor
public class SalesController {

    private final SalesService salesService;

    @PostMapping("/receipt-details")
    public ReceiptDetails computeReceiptDetails(@RequestBody List<ProductLineInput> productLines) {
        return salesService.computeReceiptDetails(productLines);
    }
}
