Feature: Sites Functionality
  Scenario Outline: check sites list
    Given User is  on the Sites List Page
    Then A list of  sites should be displayed "<sitesName>"
    Examples:
      |sitesName|
      |Mare-Jodoin|

  Scenario Outline: search for the site
    Given User is  on the Sites List Page
    When User search for the site by "<sitesName>"
    Then the site "<sitesName>" should be displayed
    Examples:
      | sitesName   |
      | Mare-Jodoin |

  Scenario Outline:  see the site's info
    Given User is  on the Sites List Page
    Then A list of  sites should be displayed "<sitesName>"
    And All site's info should be displayed
    Examples:
      |sitesName|
      |Mare-Jodoin|


  Scenario: Filter roaming users
    Given  User is  on the Sites List Page
    When  User  click filterBtn
    And User  enables the roaming users filter
    And User  applies the filter
    Then Only  the roaming users should be displayed in the list

  Scenario:Return to sites list page from filters page:
    Given  User is  on the Sites List Page
    When User  click filterBtn
    And User clicks   the exit button
    Then User  should be redirected to the Users List Page

  Scenario Outline:open site area list page :
    Given  User is  on the Sites List Page
    When User  click to open site area of "<sitesName>"
    Then User  should be redirected to the Site area List Page : "<sitesName>"
    Examples:
      |sitesName|
      |Mare-Jodoin|

  Scenario:open sites in the map view page :
    Given  User is  on the Sites List Page
    When user switch to the sites map page
    Then User  should be redirected to the Sites Map Page