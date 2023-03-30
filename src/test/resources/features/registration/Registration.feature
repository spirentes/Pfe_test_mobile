Feature: Registration
@successful
  @stepdef=SuccessfulRegistrationSteps
  Scenario Outline: User successfully registers with valid details
    Given User clicks on the new user button
    When User enters "<FirstName>", "<LastName>", "<Email>", and "<Password>"
    And User accepts the terms and conditions
    And User clicks on the register button
    Then User should be registered successfully

    Examples:
      | FirstName | LastName | Email                      | Password     |
      | oumaima   | kalboussi  | kalboussioumaima1234@gmail.com | Password123* |
      | sabri     | mejri   | mejrisabri@gmail.com      | Password12** |

  @failed
    @stepdef=FailedRegistrationSteps
  Scenario Outline: User registers with existing email
    Given User is on the registration page
    When User enters "<FirstName>", "<LastName>", "<InvalidEmail>", and "<Password>" with an existing email address
    And User accepts the terms and conditions  For Failed Registration
    And User clicks on the register button For Failed Registration
    Then User should see an error message indicating that the email already exists

    Examples:

      | FirstName | LastName  | InvalidEmail                   | Password     |
      | oumaima   | kalboussi | kalboussioumaima12@gmail.com | Password123* |

  @failed
  @stepdef=FailedRegistrationSteps
  Scenario: User enters password with less than 8 characters
    Given User is on the registration page
    When User enters a password with less than 8 characters
    And User accepts the terms and conditions
    And User clicks on the register button
    Then User should see an error message indicating that the password is too short


  @failed
  @stepdef=FailedRegistrationSteps
  Scenario: User enters password without special character
    Given User is on the registration page
    When User enters a password without a special character
    And User accepts the terms and conditions
    And User clicks on the register button
    Then User should see an error message indicating that the password must contain at least one special character




