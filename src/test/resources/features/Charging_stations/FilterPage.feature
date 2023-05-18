Feature: Charging Stations filter Page Functionality
  @available
  Scenario Outline: filter by available charging stations
    Given User is  on the Charging Stations filer Page
    When user clicks on available charging stations button
    And user clicks on apply button
    Then only available "<available_CS>" should be displayed
    Examples:
      | available_CS |
      |CS-ABB-00001, CS-ABB-00002|

  @roaming
  Scenario Outline: filter by roaming charging stations
    Given User is  on the Charging Stations filer Page
    When user clicks on roaming charging stations button
    And user clicks on apply button
    Then "<roaming_CS>" should be displayed
    Examples:
      | roaming_CS |
      |CS-ABB-00001, CS-ABB-00002|

  @type
  Scenario Outline: filter by single charging station connector type
    Given User is  on the Charging Stations filer Page
    When user choose charging station connector type "<connectorType>"
    And user clicks on apply button
    Then charging stations with selected "<connectorType>" should be displayed
    Examples:
      | connectorType |
      |Type 1|

  @Multiple_type
  Scenario Outline: filter by multiple charging station connector type
    Given User is  on the Charging Stations filer Page
    When user choose Multiple charging station connector types "<connectorType1>" and "<connectorType2>"
    And user clicks on apply button
    Then charging stations with selected "<connectorType1>"and "<connectorType2>" should be displayed
    Examples:
      | connectorType1 | connectorType2 |
      |Type 1|Domestic|