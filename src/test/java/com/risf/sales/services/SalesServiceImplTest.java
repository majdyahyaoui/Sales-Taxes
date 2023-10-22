package com.risf.sales.services;

import com.risf.sales.dto.ProductInput;
import com.risf.sales.dto.ProductLineInput;
import com.risf.sales.dto.ReceiptDetails;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.math.BigDecimal;
import java.util.List;

public class SalesServiceImplTest {

    @InjectMocks
    private SalesService salesService = new SalesServiceImpl();

    @Test
    public void input1() {
        //prepare
        ProductLineInput book = new ProductLineInput(1,
                new ProductInput("book",
                        false,
                        true,
                        false,
                        false,
                        BigDecimal.valueOf(12.49)));
        ProductLineInput musicCD = new ProductLineInput(1,
                new ProductInput("musicCD",
                        false,
                false,
                        false,
                        false,
                        BigDecimal.valueOf(14.99)));
        ProductLineInput chocolateBar = new ProductLineInput(1,
                new ProductInput("chocolate bar",
                        true,
                        false,
                        false,
                        false,
                        BigDecimal.valueOf(0.85)));
        List<ProductLineInput> productLines = List.of(book, musicCD, chocolateBar);

        //execute
        ReceiptDetails receiptDetails = salesService.computeReceiptDetails(productLines);

        //assert
        Assertions.assertEquals(BigDecimal.valueOf(29.83).compareTo(receiptDetails.totalTTC()),0);
        Assertions.assertEquals(BigDecimal.valueOf(1.50).compareTo(receiptDetails.totalTaxes()),0);
    }

    @Test
    public void input2() {
        //prepare
        ProductLineInput boxOfChocolates = new ProductLineInput(1,
                new ProductInput("box of chocolates",
                        true,
                        false,
                        false,
                        true,
                        BigDecimal.valueOf(10.00)));
        ProductLineInput bottleOfPerfume = new ProductLineInput(1,
                new ProductInput("bottle of perfume",
                        false,
                        false,
                        false,
                        true,
                        BigDecimal.valueOf(47.50)));
        List<ProductLineInput> productLines = List.of(boxOfChocolates, bottleOfPerfume);

        //execute
        ReceiptDetails receiptDetails = salesService.computeReceiptDetails(productLines);

        //assert
        Assertions.assertEquals(BigDecimal.valueOf(65.15).compareTo(receiptDetails.totalTTC()),0);
        Assertions.assertEquals(BigDecimal.valueOf(7.65).compareTo(receiptDetails.totalTaxes()),0);
    }

    @Test
    public void input3() {
        //prepare
        ProductLineInput bottleOfPerfume = new ProductLineInput(1,
                new ProductInput("bottle of perfume",
                        false,
                        false,
                        false,
                        true,
                        BigDecimal.valueOf(27.99)));
        ProductLineInput bottleOfPerfume2 = new ProductLineInput(1,
                new ProductInput("bottle of perfume 2",
                        false,
                        false,
                        false,
                        false,
                        BigDecimal.valueOf(18.99)));
        ProductLineInput headachePills = new ProductLineInput(1,
                new ProductInput(" packet of headache pills",
                        false,
                        false,
                        true,
                        false,
                        BigDecimal.valueOf(9.75)));
        ProductLineInput chocolates = new ProductLineInput(1,
                new ProductInput(" chocolates",
                        true,
                        false,
                        false,
                        true,
                        BigDecimal.valueOf(11.25)));
        List<ProductLineInput> productLines = List.of(bottleOfPerfume, bottleOfPerfume2, headachePills, chocolates);

        //execute
        ReceiptDetails receiptDetails = salesService.computeReceiptDetails(productLines);

        //assert
        Assertions.assertEquals(BigDecimal.valueOf(74.68).compareTo(receiptDetails.totalTTC()),0);
        Assertions.assertEquals(BigDecimal.valueOf(6.70).compareTo(receiptDetails.totalTaxes()),0);
    }
}