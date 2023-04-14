Feature: users page functionality

  Scenario Outline: check users list
Given User is  on the Users List Page
Then A list of  users  should be displayed "<usersName>"
Examples:
|usersName|
|   ADMIN Admin    |
|  TESTDEMO User  |
|   TRITAR Rania   |

    Scenario: Filter roaming users
      Given  User is  on the Users List Page
      When  User click filterBtn
      And User enables the roaming users filter
      And User applies the filter
      Then Only the roaming users should be displayed in the list

  Scenario:Return to users list page from filters page:
    Given  User is  on the Users List Page
    When User click filterBtn
    And User clicks  the exit button
    Then User should be redirected to the Users List Page

