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



