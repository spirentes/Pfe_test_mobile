package steps.chargingStationList;

import PageObjects.*;
import PageObjects.navbar.NavSidebarMenuPage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.ITestContext;
import tests.base.BaseTests;

import java.net.MalformedURLException;

import static org.junit.Assert.*;

public class ChargingStationsListPageSteps extends BaseTests {

    private AndroidDriver            driver;
    private ChargingStationsListPage chargingStationsListPage;
    private NavSidebarMenuPage       navigationMenuPage;
    private ScanChargingStations     scanChargingStationsPage;
    private FiltersPage                 filtersPage;
    private ActionsChargingStationsPage actionsChargingStationsPage;
    private ChargePointCSPage         chargePointCSPage;
    private SearchChargingStationsMapPage searchChargingStationsMapPage;



    @Given("I am on the Charging Stations List Page")
    public void givenIAmOnTheChargingStationsListPage() throws MalformedURLException {
        configureAppium();
        chargingStationsListPage = new ChargingStationsListPage(driver);
        assertTrue(chargingStationsListPage.isOnPage());
    }

    @When("I click on the Navigation Menu icon")
    public void whenIClickOnTheNavigationMenuIcon() {
        chargingStationsListPage.openNavMenu();
    }

    @Then("the Navigation Menu should be displayed")
    public void thenTheNavigationMenuShouldBeDisplayed() {
        navigationMenuPage = new NavSidebarMenuPage (driver);
        assertTrue(navigationMenuPage.isOnPage());
    }

    @When("I click on the Scan Charging Stations button")
    public void whenIClickOnTheScanChargingStationsButton() {
        scanChargingStationsPage = chargingStationsListPage.openScanCS();
    }

    @Then("the Scan Charging Stations page should be opened")
    public void thenTheScanChargingStationsPageShouldBeOpened() {
        assertTrue(scanChargingStationsPage.isOnPage());
    }

    @When("I search for a Charging Station with name {string}")
    public void whenISearchForAChargingStationWithName(String nameCS) {
        chargingStationsListPage.searchForCS(nameCS);
    }

    @Then("the Charging Station with name {string} should be displayed")
    public void thenTheChargingStationWithNameShouldBeDisplayed(String nameCS) {
        assertTrue(chargingStationsListPage.isCSDisplayed(nameCS));
    }

    @When("I click on the Filter icon")
    public void whenIClickOnTheFilterIcon() {
        filtersPage = chargingStationsListPage.openFilterPage();
    }

    @Then("the Filter page should be opened")
    public void thenTheFilterPageShouldBeOpened() {
        assertTrue(filtersPage.isOnPage());
    }

    @When("I click on the Clear Search Field button")
    public void whenIClickOnTheClearSearchFieldButton() {
        chargingStationsListPage.clearSearchField();
    }

    @Then("the Search Field should be cleared")
    public void thenTheSearchFieldShouldBeCleared() {
        assertTrue(chargingStationsListPage.isSearchFieldEmpty());
    }

    @When("I click on the Action button")
    public void whenIClickOnTheActionButton() {
        actionsChargingStationsPage = chargingStationsListPage.openActionPage();
    }

    @Then("the Action Charging Stations page should be opened")
    public void thenTheActionChargingStationsPageShouldBeOpened() {
        assertTrue(actionsChargingStationsPage.isOnPage());
    }

    @When("I click on the Heartbeat icon of a Charging Station")
    public void whenIClickOnTheHeartbeatIconOfAChargingStation() {
        chargingStationsListPage.StatusCS();
    }

//    @Override
//    public
//    void onStart ( ITestContext context ) {
//
//    }
}

