Feature: Successful Registration

  Scenario Outline: User registers with valid information
    Given I am on the registration page
    When I enter "<FirstName>" as the first name
    And I enter "<LastName>" as the last name
    And I enter "kalboussioumaima02@gmail.com" as the email
    And I enter "Password123*" as the password
    And I accept the terms and conditions
    And I click on the register button
    Then I should see the login page

    Examples:
      | FirstName | LastName |
      | oumaima   | kalboussi|
      | sabri     | mejri    |