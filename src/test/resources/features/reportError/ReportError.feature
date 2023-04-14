Feature: Report Error Functionality
@successful
  Scenario Outline: Report Error with valid information
    Given User is  on the Report Error Page
    When the user enter  "<Mobile>","<Error title>" and "<Description>"
    And User clicks on Send Btn
    Then The report should be sent and the user redirected to the charging station map Page
    Examples:
      |Mobile|Error title|Description
      |+21694676543|Error title|Description
      |+21694576545|Error title1|Description1

  @failed
  Scenario Outline: Report Error with invalid mobile number
    Given User is  on the Report Error Page
    When the user enter  "<Mobile>","<Error title>" and "<Description>"
    And User clicks on Send Btn
    Then An error message should be displayed

    Examples:
      | Mobile         | Error title | Description |
      | 1234           | Error title| Description |
      | +1 (123) 45678 | Error title| Description |
      |       | Error title| Description |

  @failed2
  Scenario Outline: Report Error with empty fields
    Given User is  on the Report Error Page
    When the user enter  "<Mobile>","<Error title>" and "<Description>"
    And User clicks on Send Btn
    Then An error message should be displayed next to each empty field

    Examples:
      | Mobile | Error title | Description |
      |+21694676543|          | Description |
      |+21694676543| Error title|             |