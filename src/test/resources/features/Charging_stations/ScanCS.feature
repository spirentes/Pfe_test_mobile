Feature: Scan Charging Stations  Functionality
  Scenario: Check  Charging Station Status
    Given User is  on the Charging Stations List Page
    When user clicks on the Heartbeat icon of a Charging Station "<CsName>"
    Then the Charging Station status should be displayed