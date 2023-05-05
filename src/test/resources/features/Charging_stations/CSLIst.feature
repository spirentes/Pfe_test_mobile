Feature: Charging Stations List Page Functionality

  Scenario Outline: check charging stations list
    Given User is  on the Charging Stations List Page
    Then A list of  charging stations  should be displayed "<CsName>"
    Examples:
      |CsName|
      |CS-SCHNEIDER-00001 |
      |CS-ABB-00002       |
      |CS-ABB-00001      |
    Scenario Outline: Search for Charging Station
    Given User is  on the Charging Stations List Page
    When  User search for a Charging Station with name "<CsName>"
    Then the Charging Station with name "<CsName>" should be displayed
    Examples:
      | CsName|
      | CS-ABB-00001     |
    Scenario: Clear Search Field
    Given User is  on the Charging Stations List Page
    When User clicks on the Clear Search Field button
    Then the Search Field should be cleared

  Scenario Outline: Check Charging Station Status
    Given User is  on the Charging Stations List Page
    When user clicks on the Heartbeat icon of a Charging Station "<CsName>"
    Then the Charging Station status should be displayed
    Examples:
      |CsName|
      |CS-SCHNEIDER-00001 |

  Scenario Outline:  inactive Charging Station
    Given User is  on the Charging Stations List Page
    When Charging Station "<CsName>" is not  active
    And  User clicks on more info button "<CsName>"
    Then user can not perform any action on "<CsName>"

    Examples:
      |CsName|
#      |CS-SCHNEIDER-00001 |
      |CS-ABB-00002       |
#      |CS-ABB-00001       |

  Scenario Outline: See More Information about Charging Station
    Given User is  on the Charging Stations List Page
    When I click on the More Info button of a Charging Station "<CsName>"
    Then the  Charging Station actions page should be opened
    Examples:
      |CsName|
      #|CS-SCHNEIDER-00001 |
      |CS-ABB-00002       |

  Scenario: Switch to Map View
    Given User is  on the Charging Stations List Page
    When I click on the Map View icon
    Then the Search Charging Stations Map page should be opened
  @tag
  Scenario Outline: Open Scan Charging Stations Page
    Given User is  on the Charging Stations List Page
    When  User click on the Scan Charging Stations button
    And   user scan a valid "<qr_code>"
    Then  a news charging station
    Examples:
      | qr_code |
      |resources/cs_qr_codes/qr_code.png|

