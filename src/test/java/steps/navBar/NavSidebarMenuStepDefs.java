package steps.navBar;

import PageObjects.*;
import PageObjects.Paymentmethod.PaymentMethodsPage;
import PageObjects.RFID.RFIDCardsListPage;
import PageObjects.cars.CarsPage;
import PageObjects.charging_stations.ScanChargingStations;
import PageObjects.charging_stations.SearchChargingStationsMapPage;
import PageObjects.invoices.InvoicesPage;
import PageObjects.login.LoginPage;
import PageObjects.navbar.NavSidebarMenuPage;
import PageObjects.reportError.ReportErrorPage;
import PageObjects.sites.SitesListPage;
import PageObjects.users.UsersListPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;


import tests.base.BaseTests;

import java.net.MalformedURLException;

import static org.testng.Assert.assertTrue;

public class NavSidebarMenuStepDefs  extends BaseTests {

    NavSidebarMenuPage            navSidebarMenuPage;
    SitesListPage                 sitesListPage;
    SearchChargingStationsMapPage searchChargingStationsMapPage;
    ScanChargingStations          scanChargingStations;
    SessionsInProgressListPage    sessionsInProgressListPage;
    SessionsHistoryListPage sessionsHistoryListPage ;
    StatisticsPage    statisticsPage ;
    UsersListPage     usersListPage ;
    RFIDCardsListPage  rfidCardsListPage;
    CarsPage           carsPage ;
    PaymentMethodsPage paymentMethodsPage;

    InvoicesPage    invoicesPage ;
    ReportErrorPage reportErrorPage;
    LoginPage       loginPage ;
    @Before
    public void openNavBarMenu(){

        SearchChargingStationsMapPage searchChargingStationsMapPage= new SearchChargingStationsMapPage ( driver );
        searchChargingStationsMapPage.clickNavBarBtn ();
    }
    @After ( value = "not @openCS and not @logOUT")
    public void clickBack(){
        System.out.println ( "im going back !!!!!!!!!!!" );
        driver.navigate ().back ();
    }


    @Given("the user is on the navigation sidebar menu page")
    public void userIsOnNavSidebarMenuPage() throws MalformedURLException {
        navSidebarMenuPage = new NavSidebarMenuPage(driver);
        assertTrue(navSidebarMenuPage.isOnPage());
    }

    @When("the user clicks the QR code scanner button")
    public void userClicksQRCodeScanner() {
        navSidebarMenuPage.clickQRCodeScanner();
    }
    @Then("User should be taken to the QR Code Scanner page")
    public void QRCodeScannerPageIsDisplayed() {
        scanChargingStations=new ScanChargingStations ( driver );
        assertTrue ( scanChargingStations.isOnPage () );

    }

    @When("the user clicks the sites button")
    public void userClicksSites() {
        navSidebarMenuPage.clickSites();
    }

    @Then("User should be taken to the sites page")
    public void SitesPageIsDisplayed() {
        sitesListPage=new SitesListPage ( driver );
        assertTrue ( sitesListPage.isOnPage ( ) );

    }
    @When("the user clicks the charging stations button")
    public void userClicksChargingStations() {
        navSidebarMenuPage.clickChargingStations();
    }

    @Then("User should be taken to the charging stations page")
    public void CSPageIsDisplayed() {
        searchChargingStationsMapPage=new SearchChargingStationsMapPage ( driver );
        assertTrue ( searchChargingStationsMapPage.isOnPage ( ) );

    }

    @When("the user clicks the sessions history button")
    public void userClicksSessionsHistory() {
        navSidebarMenuPage.clickSessionsHistory();
    }
    @Then("User should be taken to the sessions history page")
    public void SessionHistoryPageIsDisplayed() {
        sessionsHistoryListPage=new SessionsHistoryListPage ( driver );
        assertTrue ( sessionsHistoryListPage.isOnPage ( ) );

    }


    @When("the user clicks the sessions in progress button")
    public void userClicksSessionsInProgress() {
        navSidebarMenuPage.clickSessionsInProgress();
    }

    @Then("User should be taken to the sessions in progress page")
    public void SessionInProgressIsDisplayed() {
        sessionsInProgressListPage=new SessionsInProgressListPage ( driver );
        assertTrue ( sessionsInProgressListPage.isOnPage ( ) );

    }
    @When("the user clicks the statistics button")
    public void userClicksStatistics() {
        navSidebarMenuPage.clickStatistics();
    }
    @Then("User should be taken to the Statistics in progress page")
    public void StatisticsIsDisplayed() {
        statisticsPage=new StatisticsPage ( driver );

        assertTrue ( statisticsPage.isOnPage ( ) );

    }
    @When("the user clicks the users button")
    public void userClicksUsers() {
        navSidebarMenuPage.clickUsers();
    }
    @Then("User should be taken to the users page")
    public void UsersPageIsDisplayed() {
        usersListPage=new UsersListPage ( driver );

        assertTrue ( usersListPage.isOnPage ( ) );

    }
    @When("the user clicks the RFID cards button")
    public void userClicksRFIDCards() {
        navSidebarMenuPage.clickRFIDCards();
    }
    @Then("User should be taken to the RFID cards page")
    public void RFIDCardsIsDisplayed() {
        rfidCardsListPage=new RFIDCardsListPage (  driver);
        assertTrue (rfidCardsListPage.isOnPage ( ) );

    }
    @When("the user clicks the Cars button")
    public void userClicksCars() {
        navSidebarMenuPage.clickCars();
    }
    @Then("User should be taken to the Cars page")
    public void CarsIsDisplayed() {
        carsPage=new CarsPage (  driver);
        assertTrue (carsPage.isOnPage ( ) );

    }
    @When("the user clicks the payment methods button")
    public void userClicksPaymentMethods() {
        navSidebarMenuPage.clickPaymentMethods();
    }
    @Then("User should be taken to the payment methods page")
    public void PaymentMethodsIsDisplayed() {
        paymentMethodsPage=new PaymentMethodsPage ( driver );
        assertTrue ( paymentMethodsPage.isOnPage ( ) );

    }
    @When("the user clicks the invoices button")
    public void userClicksInvoices() {
        navSidebarMenuPage.clickInvoices();
    }

    @Then("User should be taken to the invoices page")
    public void InvoicesIsDisplayed() {
        invoicesPage=new InvoicesPage ( driver );
        assertTrue(invoicesPage.isOnPage());

    }
    @When("the user clicks the report error button")
    public void userClicksReportError() {
        navSidebarMenuPage.ScrollUp (  );
        navSidebarMenuPage.clickReportError ();
    }
    @Then ("User should be taken to the report error  page")
    public
    void userShouldBeTakenToTheReportErrorPage ( ) {
        reportErrorPage=new ReportErrorPage ( driver );
        assertTrue ( reportErrorPage.isOnPage());
    }

//    @Override
//    public
//    void onStart ( ITestContext context ) {
//
//    }
}