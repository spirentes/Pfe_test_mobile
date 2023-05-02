Feature: RFID Functionality
  Scenario Outline: check rfids list
    Given User is  on the RFID List Page
    Then A list of  rfids should be displayed "<rfidsName>"
    Examples:
      |rfidsName|
      |AC522252|
      |DC5D7A9E|
      |Sasan 1CE21FF9|
      |Badge virtuel|
  Scenario Outline: search for the rfid
    Given User is  on the RFID List Page
    When User search for the rfid by "<rfidsName>"
    Then the rfid "<rfidsName>" should be displayed
    Examples:
      |rfidsName|
      |AC522252|
      |DC5D7A9E|
      |Sasan 1CE21FF9|
      |Badge virtuel|


  @useTheUserFilter

  Scenario Outline: Search for the users by their name
    Given User is  on the RFID List Page
    When User is on the User Selection Page
    And User enters "<userName>" in the search field
    Then A list of users containing "<userNames>" should be displayed
    Examples:
      | userName |userNames  |
      | ADMIN    |ADMIN Admin   |
      | OUMAIMA  |OUMAIMA kalboussi |

  Scenario Outline: Select user by name
    Given User is  on the RFID List Page
    When User is on the User Selection Page
    And User enters "<userName>" in the search field
    And User selects the user "<selectedUserName>"
    Then The user "<selectedUserName>" should be selected
    Examples:
      |userName|selectedUserName|
      | ADMIN    |ADMIN Admin   |
      | OUMAIMA  |OUMAIMA kalboussi |