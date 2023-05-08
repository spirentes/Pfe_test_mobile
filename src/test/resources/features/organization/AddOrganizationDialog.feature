Feature: Add an Organization Dialog
  @DialogOrg
  Scenario: User clicks on QR code button
    Given User is on Add an Organization dialog
    When User clicks on the QR code button
    Then QR code scanner is activated
  @DialogOrg
  Scenario: User clicks on manually button
    Given User is on Add an Organization dialog
    When User clicks on the manually button
    Then User is redirected to the manual organization page
  @DialogOrg
  Scenario: User clicks on cancel button
    Given User is on Add an Organization dialog
    When User clicks on the cancel button
    Then Add an Organization dialog is closed
  @DialogOrg
  Scenario: User clicks on exit button
    Given User is on Add an Organization dialog
    When User clicks on the exist button
    Then  add Organization dialog is closed