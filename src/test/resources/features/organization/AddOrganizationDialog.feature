Feature: Add an Organization Dialog
  @scanOrg
  Scenario: User clicks on QR code button
    Given User is on Add an Organization dialog
    When User clicks on the QR code button
    Then QR code scanner is activated

  @successful_creation
  Scenario Outline: User successfully add an organization with valid details
    Given   User is on Add an Organization dialog
    When User clicks on the manually button
    And User is redirected to the manual organization page
    And User   enters "<SubDomain>" and "<Name>"
    And User clicks on the create button
    Then  organization created successfully and a alert dialog is shown asking for registration on logging in
    Examples:
      | SubDomain  | Name|
      | testMobile | organizationName|
      |subdomaintest|orgNameTESt     |
  @failed_creation
  Scenario Outline: User use an existing Subdomain
    Given User is on Add an Organization dialog
    When User clicks on the manually button
    And User is redirected to the manual organization page
    And User   enters "<SubDomain>" and "<Name>"
    And User clicks on the create button
    Then red message tell user that  the subdomain is already in use
    Examples:
      | SubDomain   | Name             |
      | testMobile | organizationName |
#  Scenario: User clicks on cancel button
#    Given User is on Add an Organization dialog
#    When User clicks on the cancel button
#    Then Add an Organization dialog is closed
#  Scenario: User clicks on exit button
#    Given User is on Add an Organization dialog
#    When User clicks on the exist button
#    Then  add Organization dialog is closed