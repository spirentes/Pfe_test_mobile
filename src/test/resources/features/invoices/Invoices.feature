Feature: Invoices page functionality

  Scenario Outline: check Invoices list
    Given User is  on the Invoices Page
    Then A list of Invoices should be displayed "<Invoices>"
    Examples:
      |Invoices|
      |123456|


