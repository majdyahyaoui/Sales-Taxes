Feature: Sales price TTC compute
  Scenario: client makes call to POST /sales/receipt-details
    Given I have the following product line as input
      | 1 | book | false | true | false | false | 12.49 |
      | 1 | music cd | false | false | false | false | 14.99 |
      | 1 | chocolate bar | true | false | false | false | 0.85 |
    When I compute receipt details
    Then I should find 29.83 as total price TTC and 1.50 as sales taxes