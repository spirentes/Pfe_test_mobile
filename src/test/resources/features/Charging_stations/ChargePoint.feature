Feature: Charge Point Page Functionality

#  Scenario: Start session successfully
#    Given User is on the Charge Point Page
#    When user and RFID_card are active
#    And  user clicks start session
#    And  user clicks yes
#    Then a session should be started
#  Scenario: stop session
#    Given User is on the  stop Charge Point Page
#    When user clicks on stop icon
#    And  user clicks yes
#    Then session is closed and user go back to start session page
#  Scenario Outline: can not start session
#    Given User is on the Charge Point Page
#    When "<user>" or RFID_card is inactive
#    Then start session btn is disabled  and user can not start session
#    Examples:
#      | user |
#      |OUMAIMA kalboussi|

#  Scenario Outline: can not start session
#    Given User is on the Charge Point Page
#    When "<user>" is not associated with an RFID card
#    Then no RFID card message should be displayed
#    Then start session btn is disabled  and user can not start session
#    Examples:
#      | user |
#      |TESTDEMO User|
  Scenario Outline: select a car
    Given User is on the Charge Point Page
    When user click on the  add car btn
    And  when user chose a "<car>"
    And  user set the "<vin>" ,"<License Plate>","<Default car>","<car type>"
    Then the car should be added
    Examples:
      | car | vin | License Plate | Default car | car type |
      |Aiways U5 |4Y1SL65848Z411439|123456|no|Company car|
#  Scenario: go to session information page
#    Given User is on the Charge Point Page
#    When user clicks on session icon
#    Then user should be redirected to the session page and all thd information should be displayed
#
#  Scenario: report error
#    Given User is on the Charge Point Page
#    When user clicks on report error icon
#    Then user should be redirected to the report error page
