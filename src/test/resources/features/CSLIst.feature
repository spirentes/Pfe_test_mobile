Feature: Charging Stations List Page Functionality

  Scenario: Open Navigation Menu
    Given I am on the Charging Stations List Page
    When I click on the Navigation Menu icon
    Then the Navigation Menu should be displayed

  Scenario: Open Scan Charging Stations Page
    Given I am on the Charging Stations List Page
    When I click on the Scan Charging Stations button
    Then the Scan Charging Stations page should be opened

  Scenario: Search for Charging Station
    Given I am on the Charging Stations List Page
    When I search for a Charging Station with name "Test CS"
    Then the Charging Station with name "Test CS" should be displayed

  Scenario: Open Filter Page
    Given I am on the Charging Stations List Page
    When I click on the Filter icon
    Then the Filter page should be opened

  Scenario: Clear Search Field
    Given I am on the Charging Stations List Page
    When I click on the Clear Search Field button
    Then the Search Field should be cleared

  Scenario: Open Action Charging Stations Page
    Given I am on the Charging Stations List Page
    When I click on the Action button
    Then the Action Charging Stations page should be opened

  Scenario: Check Charging Station Status
    Given I am on the Charging Stations List Page
    When I click on the Heartbeat icon of a Charging Station
    Then the Charging Station status should be displayed

  Scenario: See More Information about Charging Station
    Given I am on the Charging Stations List Page
    When I click on the More Info button of a Charging Station
    Then the Charge Point Charging Station page should be opened

  Scenario: Switch to Map View
    Given I am on the Charging Stations List Page
    When I click on the Map View icon
    Then the Search Charging Stations Map page should be opened

  Scenario: Apply filter to charging stations
    Given I am on the Charging Stations List page
    When I tap on the filter icon
    And I select the "Tesla" filter
    Then the charging stations list should update, showing only charging stations with "Tesla" in the name

  Scenario: View charging stations on a map
    Given I am on the Charging Stations List page
    When I tap on the "Map View" icon
    Then the Search Charging Stations Map page should open, showing charging stations plotted on a map