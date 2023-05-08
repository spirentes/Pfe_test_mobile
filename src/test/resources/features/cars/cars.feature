Feature: CarsPage Functionality
  Scenario Outline: check cars list
    Given User is  on the cars List Page
    Then A list of cars should be displayed "<carsName>"
    Examples:
      |carsName|
      |123456|

  Scenario Outline: search for the rfid
    Given User is  on the cars List Page
    When User search for the cars by "<carsName>"
    Then the cars "<carsName>" should be displayed
    Examples:
      |carsName|
      |123456|


  Scenario Outline: Select user by name
    Given User is  on the cars List Page
    When User  is on the User Selection Page
    And User  enters "<userName>" in the search field
    And A list  of users containing "<userNames>" should be displayed
    And User  selects the user "<selectedUserName>"
    Then The user  "<selectedUserName>" should be selected
    Examples:
      |userName|userNames  |selectedUserName|
      | OUMAIMA  |OUMAIMA kalboussi |OUMAIMA kalboussi |

  Scenario Outline: Add a car
    Given User is  on the cars List Page
    When user click on the add car btn
    And  when user chose a  "<car>"
    And  user set the  "<vin>" ,"<License Plate>","<Default car>","<car type>"
    Then the car should be  added "<License Plate>"
    Examples:
      | car | vin | License Plate | Default car | car type |
      |Aiways U5 |4Y1SL65848Z411439|123456|no|Company car|


#  Scenario : Filter by default user

