Feature: Successful Registration

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
