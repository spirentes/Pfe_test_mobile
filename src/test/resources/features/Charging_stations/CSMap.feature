Feature: Charging Stations Map Page Functionality

  Scenario Outline: View charging stations on a map
    Given user is  on the Charging Stations map page
    Then the charging stations "<Csname>" should be  plotted on a map
    Examples:
      |Csname|
  #|CS-ABB-00001 |
      |CS-ABB-00002|
      |CS-SCHNEIDER-00001|

  Scenario Outline: Search for Charging Station
    Given user is  on the Charging Stations map page
    When  User search for a Charging Station with cs name "<CsName>"
    Then the Charging Station with name "<CsName>" should be displayed on the map
    Examples:
      | CsName|
      | CS-ABB-00002     |
  @active
  Scenario Outline: Check active Charging Station
    Given user is  on the Charging Stations map page
    When Charging Station "<CsName>" is  active
    And  User tap on the Charging Station icon "<CsName>"
    Then "<CsName>",unavailable connector message ,red heartbeat,power consumption should be displayed and user can  perform any action

    Examples:
      |CsName|
      |CS-ABB-00002 |
  @inactive
  Scenario Outline: Check inactive Charging Station
    Given user is  on the Charging Stations map page
    When Charging Station "<CsName>" is not active
    And  User tap on the Charging Station icon "<CsName>"
    Then "<CsName>",unavailable connector message ,red heartbeat,power consumption should be displayed and user can not perform any action

    Examples:
      |CsName|
      |CS-SCHNEIDER-00001 |
  @ocpp
  Scenario Outline: check charging station ocpp parameters
    Given user is  on the Charging Stations map page
    When  User tap on the Charging Station icon "<CsName>"
    And    user clicks more info button
    And    user clicks on ocpp icon
    Then the charging stations ocpp parameters should be displayed
    Examples:
      |CsName|
      |CS-ABB-00002 |
  @properties
  Scenario Outline: check charging station  properties
    Given user is  on the Charging Stations map page
    When  User tap on the Charging Station icon "<CsName>"
    And    user clicks more info button
    And    user clicks on properties icon
    Then the charging stations  properties should be displayed
    Examples:
      |CsName|
      |CS-ABB-00002 |
  Scenario: switch to satellite  map Page View
    Given user is  on the Charging Stations map page
    When user clicks on the satellite view icon
    Then the charging stations satellite  map page should be displayed
  Scenario: switch to list Page View
    Given user is  on the Charging Stations map page
    When user clicks on the list view icon
    Then the charging stations list page should be displayed