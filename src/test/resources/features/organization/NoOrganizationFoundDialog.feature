Feature: NO Organization Found
  Scenario: User clicks on Yes in the No Organization Found alert
    Given the user has the No Organization Found alert displayed
    When the user clicks Yes
    Then the user is redirected to the QR code scanning page

  Scenario: User clicks on Cancel in the No Organization Found alert
    Given the user has the No Organization Found alert displayed
    When the user clicks Cancel
    Then the alert is dismissed and the user redirected to the login page
  Scenario: User clicks on Exist button  in the No Organization Found alert
    Given the user has the No Organization Found alert displayed
    When the user clicks the Exit button
    Then the alert is dismissed and the user redirected to login page
