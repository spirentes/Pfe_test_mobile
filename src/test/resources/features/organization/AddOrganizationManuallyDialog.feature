Feature: Add Organization Manually Dialog
  @successful_creation
  Scenario Outline: User successfully add an organization with valid details
    Given   User is on Add an Organization Manually dialog
    When User enters "<SubDomain>" and "<Name>"
    And User clicks on the create button
    Then  organization created successfully and a alert dialog is shown asking for registration on logging in
    Examples:
      | SubDomain  | Name|
      | testMobile | organizationName|
      |subdomaintest|orgNameTESt     |
@failed_creation
  Scenario Outline: User use an existing Subdomain
    Given User is on Add an Organization Manually dialog
    When User enters "<SubDomain>" and "<Name>"
    And User clicks on the create button
    Then red message tell user that  the subdomain is already in use
    Examples:
      | SubDomain   | Name             |
      | testMobile | organizationName |