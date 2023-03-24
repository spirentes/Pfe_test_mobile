Feature: Registration

  Scenario Outline: User successfully registers with valid details
    Given User clicks on the new user button
    When User enters "<FirstName>", "<LastName>", "<Email>", and "<Password>"
    And User accepts the terms and conditions
    And User clicks on the register button
    Then User should be registered successfully

    Examples:
      | FirstName | LastName | Email                      | Password     |
      | oumaima   | kalboussi  | kalboussioumaima1@gmail.com | Password123* |
      | sabri     | mejri   | mejrisabri@gmail.com      | Password12** |


  Scenario: User registers with existing email
    Given User is on the registration page
    When User enters an existing email address
    And User accepts the terms and conditions
    And User clicks on the register button
    Then User should see an error message indicating that the email already exists

  Scenario: User does not accept terms and conditions
    Given User is on the registration page
    When User enters valid details
    And User does not accept the terms and conditions
    And User clicks on the register button
    Then User should see an error message indicating that the terms and conditions must be accepted

  Scenario: User enters invalid email address
    Given User is on the registration page
    When User enters an invalid email address
    And User accepts the terms and conditions
    And User clicks on the register button
    Then User should see an error message indicating that the email address is invalid

  Scenario: User enters password with less than 8 characters
    Given User is on the registration page
    When User enters a password with less than 8 characters
    And User accepts the terms and conditions
    And User clicks on the register button
    Then User should see an error message indicating that the password is too short

  Scenario: User enters password without special character
    Given User is on the registration page
    When User enters a password without a special character
    And User accepts the terms and conditions
    And User clicks on the register button
    Then User should see an error message indicating that the password must contain at least one special character

