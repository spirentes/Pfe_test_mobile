Feature: Registration Page

  @successful_registration
  Scenario Outline: User successfully registers with valid details
    Given User is on the registration page
    When User enters "<FirstName>", "<LastName>", "<Email>", and "<Password>"
    And User accepts the terms and conditions
    And User clicks on the register button
    Then User should be registered successfully

    Examples:
      | FirstName | LastName | Email                           | Password     |
      | oumaima   | kalboussi123| kalboussioumaima12345@gmail.com | Password123* |
      | sabri     | mejri    | mejrisabri@gmail.com            | Password12** |
#
#  Scenario: User click on new user btn without selecting an organization
#    Given User is on the login page page
#    When  User clicks on the new user btn
#    And User does not select an organization
#    Then User should see an error message indicating that he should select an organization first
  Scenario Outline: User registers with existing email
    Given User is on the registration page
    When User enters "<FirstName>", "<LastName>", "<existingEmail>", and "<Password>"
    And User accepts the terms and conditions
    And User clicks on the register button
    Then User should see an error message indicating that the email already exists
    Examples:
      | FirstName | LastName | existingEmail                    | Password     |
      | oumaima   | kalboussi  | kalboussioumaima12345@gmail.com | Password123* |
  Scenario Outline: User does not accept terms and conditions
    Given User is on the registration page
    When User enters "<FirstName>", "<LastName>", "<Email>", and "<Password>"
    And User does not accept the terms and conditions
    And User clicks on the register button
    Then User should  not be able to sign Up
    Examples:
      | FirstName | LastName | Email                      | Password     |
      | oumaima   | kalboussi  | kalboussioumaima12345@gmail.com | Password123* |

  Scenario Outline: User enters invalid email address
    Given User is on the registration page
    When User enters "<FirstName>", "<LastName>", "<invalidEmail>", and "<Password>"
    And User accepts the terms and conditions
    And User clicks on the register button
    Then User should see an error message indicating that the email is invalid
    Examples:
      | FirstName | LastName | invalidEmail                      | Password     |
      | oumaima   | kalboussi  | kalboussioumaima12345gmail.com | Password123* |

  Scenario Outline: User enters invalid password
    Given User is on the registration page
    When  User enters "<FirstName>", "<LastName>", "<Email>", and "<invalid_password>"
    And User accepts the terms and conditions
    And User clicks on the register button
    Then User should see an error message indicating that the password must be valid
    Examples:
      | FirstName | LastName | Email | invalid_password |
      | oumaima   | kalboussi  | kalboussioumaima12345@gmail.com | pass |
      | oumaima   | kalboussi  | kalboussioumaima12345@gmail.com | Password |
      | oumaima   | kalboussi  | kalboussioumaima12345@gmail.com | Password123 |
      | oumaima   | kalboussi  | kalboussioumaima12345@gmail.com | Password* |