Feature: User can login to the app
  @Successful_login
  Scenario Outline: Successful login
    Given User is on the login page
    When User enters "<Email>" and "<Password>"
    And User accepts the terms
    And User clicks on the login button
    Then User should be redirected to the search charging stations map page
    Examples:
      |Email                          |Password     |
      |sabri.mejri@internship.continuousnet.com	 | Sabri1234* |
  @Failed_login
  Scenario Outline: Login without accepting terms
    Given User is on the login page
    When User enters "<Email>" and "<Password>"
    And User does not accepts the terms
    And User clicks on the login button
    Then User should see an error message indicating that he must accept terms and conditions
    Examples:
      |Email                          |Password     |
      |sabri.mejri@internship.continuousnet.com	 | Sabri1234* |
  @Failed_login
  Scenario Outline: Login with invalid password
    Given User is on the login page
    When User enters "<Email>" and "<invalidPassword>"
    And User accepts the terms
    And User clicks on the login button
    Then User should see an error message for Wrong email or password
    Examples:
      |Email                          |invalidPassword    |
      |sabri.mejri@internship.continuousnet.com	 | invalidPassword |
  @Failed_login
  Scenario Outline: Login with invalid email
    Given User is on the login page
    When User enters "<invalidEmail>" and "<Password>"
    And User does not accepts the terms
    And User clicks on the login button
    Then User should see an error message for indicating that the email is invalid
    Examples:
      |invalidEmail                        |Password    |
      |sabri.mejriinternship.continuousnet.com	 | invalidPassword |