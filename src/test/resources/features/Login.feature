Feature: User can login to the app

  Scenario: Successful login
    Given User is on the login page
    When User enters valid credentials and accepts the terms
    And User clicks on the login button
    Then User should be redirected to the search charging stations map page

  Scenario: Login without accepting terms
    Given User is on the login page
    When User enters valid credentials without accepting the terms
    And User clicks on the login button
    Then User should see a message to accept the terms

  Scenario: Login with invalid password
    Given User is on the login page
    When User enters a valid email and an invalid password
    And User accepts the terms and clicks on the login button
    Then User should see an error message for invalid email or password

  Scenario: Login with invalid email
    Given User is on the login page
    When User enters an invalid email and a valid password
    And User accepts the terms and clicks on the login button
    Then User should see an error message for invalid email or password
