package com.risf.sales.cucumber;

import com.risf.sales.controllers.SalesController;
import com.risf.sales.dto.ProductInput;
import com.risf.sales.dto.ProductLineInput;
import com.risf.sales.dto.ReceiptDetails;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class StepDefs extends SpringIntegrationTest{

    @Autowired
    private SalesController salesController;
    private List<ProductLineInput> productLineInputs;
    private ReceiptDetails receiptDetails;

    @Before
    public void setUp() {
        productLineInputs = new ArrayList<>();
    }

    @Given("^I have the following product line as input$")
    public void haveBooksInTheStoreByList(DataTable table) {
        List<List<String>> rows = table.asLists(String.class);

        for (List<String> columns : rows) {
            productLineInputs.add(new ProductLineInput(Integer.parseInt(columns.get(0)),
                    new ProductInput(columns.get(1),
                            Boolean.parseBoolean(columns.get(2)),
                            Boolean.parseBoolean(columns.get(3)),
                            Boolean.parseBoolean(columns.get(4)),
                            Boolean.parseBoolean(columns.get(5)),
                            new BigDecimal(columns.get(6)))));
        }
    }

    @When("^I compute receipt details$")
    public void computeReceiptDetails() {
        receiptDetails = salesController.computeReceiptDetails(productLineInputs);
    }

    @Then("^I should find ([\\d\\.]*) as total price TTC and ([\\d\\.]*) as sales taxes$")
    public void checkResult(BigDecimal totalPriceTTC, BigDecimal totalTaxes) {
        Assertions.assertEquals(totalPriceTTC.compareTo(receiptDetails.totalTTC()), 0);
        Assertions.assertEquals(totalTaxes.compareTo(receiptDetails.totalTaxes()), 0);
    }

}
