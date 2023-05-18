Feature: Navigation Sidebar Menu
@openQRCodeScannerPage
  Scenario: User clicks the QR code scanner button
    Given the user is on the navigation sidebar menu page
    When the user clicks the QR code scanner button
    Then User should be taken to the QR Code Scanner page
  @openSitesPage
  Scenario: User clicks the sites button
    Given the user is on the navigation sidebar menu page
    When the user clicks the sites button
    Then User should be taken to the sites page
  @openChargingStationPage
  Scenario: User clicks the charging stations button
    Given the user is on the navigation sidebar menu page
    When the user clicks the charging stations button
    Then User should be taken to the charging stations page
@openSessionsHistoryPage
  Scenario: User clicks the sessions history button
    Given the user is on the navigation sidebar menu page
    When the user clicks the sessions history button
    Then User should be taken to the sessions history page
@openSessionInProgressPage
  Scenario: User clicks the sessions in progress button
    Given the user is on the navigation sidebar menu page
    When the user clicks the sessions in progress button
    Then User should be taken to the sessions in progress page
@openStatisticsPage
  Scenario: User clicks the statistics button
    Given the user is on the navigation sidebar menu page
    When the user clicks the statistics button
    Then User should be taken to the Statistics in progress page
@openUsersListPage
  Scenario: User clicks the users button
    Given the user is on the navigation sidebar menu page
    When the user clicks the users button
    Then User should be taken to the users page
@openRfidListPage
  Scenario: User clicks the RFID cards button
    Given the user is on the navigation sidebar menu page
    When the user clicks the RFID cards button
    Then User should be taken to the RFID cards page
  Scenario: User clicks the Cars button
    Given the user is on the navigation sidebar menu page
    When the user clicks the Cars button
    Then User should be taken to the Cars page
@openPaymentMethodsPage
  Scenario: User clicks the payment methods button
    Given the user is on the navigation sidebar menu page
    When the user clicks the payment methods button
    Then User should be taken to the payment methods page
@openInvoicesPage
  Scenario: User clicks the invoices button
    Given the user is on the navigation sidebar menu page
    When the user clicks the invoices button
    Then User should be taken to the invoices page
@openReportErrorPage
  Scenario: User clicks the report error button
    Given the user is on the navigation sidebar menu page
    When the user clicks the report error button
    Then User should be taken to the report error  page

  @logOUT
  Scenario: User clicks the log out button
    Given the user is on the navigation sidebar menu page
    When the user clicks the log out button
    Then User should be taken to the login page