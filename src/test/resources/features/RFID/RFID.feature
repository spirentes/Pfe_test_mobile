Feature: RFID Functionality
  Scenario Outline: check rfids list
    Given User is  on the RFID List Page
    Then A list of  rfids should be displayed "<rfidsName>"
    Examples:
      |rfidsName|
      |AC522252|
      |DC5D7A9E|

  Scenario Outline: search for the rfid
    Given User is  on the RFID List Page
    When User search for the rfid by "<rfidsName>"
    Then the rfid "<rfidsName>" should be displayed
    Examples:
      |rfidsName|
      |AC522252|
      |DC5D7A9E|




  Scenario Outline: Select user by name
    Given User is  on the RFID List Page
    When User is on the User Selection Page
    And User enters "<userName>" in the search field
    And A list of users containing "<userNames>" should be displayed
    And User selects the user "<selectedUserName>"
    Then The user "<selectedUserName>" should be selected
    Examples:
      |userName|userNames  |selectedUserName|
      | ADMIN    |ADMIN Admin |ADMIN Admin   |
      | OUMAIMA  |OUMAIMA kalboussi |OUMAIMA kalboussi |

    #  Scenario : Filter by default user