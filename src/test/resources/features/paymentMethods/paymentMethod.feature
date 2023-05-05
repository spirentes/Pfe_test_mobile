Feature: Payment Method functionality
  Scenario Outline: add a payment Method with valid card
    Given user is on the payment Methods page
    When user click on the plus button
    And user enters a "<valid car number>","<valid exp date>"and a "<valid cvc>"
    And  user accepts the terms and  clicks save
    Then a new payment method should be added
    Examples:
      | valid car number | valid exp date | valid cvc |
    |4000056655665556|0925|878|
    @failed
  Scenario Outline: add a existing payment Method
    Given user is on the payment Methods page
    When user click on the plus button
    And user enters a "<invalid car number>"or"<invalid exp date>"or"<invalid cvc>"
    And  user accepts the terms and  clicks save
    Then user can not add a payment method
    Examples:
      | invalid car number | invalid exp date | invalid cvc |
      | 4565 4589 5236 6895 |0618|7896|
@tag
  Scenario Outline: delete a payment Method
    Given user is on the payment Methods page
    And user swipe left the "<payment method>" then click the delete button
    And user clicks  yes
    Then the "<payment method>" should be deleted
    Examples:
      | payment method |
      |4242|
