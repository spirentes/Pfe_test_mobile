Feature: Manage Organization Page
  @add_organization_from_plus_button
  Scenario: Add a new organization
    Given User is on the the Add Organization Page
    When User click on the plus button
    Then the add organization alert dialog is shown
  @select_org
  Scenario: choose an organization
    Given User is on the the Add Organization Page
    When User see organization options and click on the first organization option
    Then User should be redirected to the login page
  @update_org
  Scenario Outline: update an organization
    Given User is on the the Add Organization Page
    When User pick an organization and click the update icon
    And update dialog and user update "<SubDomain>" and "<Name>"
    Then organization is updated
    Examples:
      | SubDomain  | Name|
      | testMobile | organizationName|
      |subdomaintest|orgNameTESt     |
  @delete_org
  Scenario: delete an organization
    Given User is on the the Add Organization Page
    When User pick an organization and click the garbage icon
    Then organization should be deleted