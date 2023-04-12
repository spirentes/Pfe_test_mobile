package steps.charging_stations.listView;

import PageObjects.charging_stations.ChargingStationsListPage;
import PageObjects.charging_stations.SearchChargingStationsMapPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.C;
import tests.base.BaseTests;

import static org.testng.Assert.assertTrue;

public class ChargingstationsListPageSteps extends BaseTests {
    SearchChargingStationsMapPage searchChargingStationsMapPage= new SearchChargingStationsMapPage(driver);
    ChargingStationsListPage chargingStationsListPage = new ChargingStationsListPage(driver);

    @Given("User is  on the Charging Stations List Page")
    public void userIsOnTheChargingStationsListPage() {
        assertTrue(chargingStationsListPage.isOnPage());
    }


    @Then("A list of  charging stations  should be displayed {string}")
    public void aListOfChargingStationsShouldBeDisplayed(String CsName) {
        assertTrue(chargingStationsListPage.isCSDisplayed(CsName));
//        boolean onpage= false;
//        if ((chargingStationsListPage.isCSDisplayed(CsName))|| chargingStationsListPage.noCsFound.isDisplayed())
//        {onpage=true;}
//        assertTrue(onpage);

    }

    @When("User search for a Charging Station with name {string}")
    public void userSearchForAChargingStationWithName(String CsName) {
        chargingStationsListPage.searchForCS(CsName);


    }

    @Then("the Charging Station with name {string} should be displayed")
    public void theChargingStationWithNameShouldBeDisplayed(String CsName) {
        assertTrue(chargingStationsListPage.isCSDisplayed(CsName));
    }

    @When("User clicks on the Clear Search Field button")
    public void userClicksOnTheClearSearchFieldButton() {
        chargingStationsListPage.clearSearchField();
    }

    @Then("the Search Field should be cleared")
    public void theSearchFieldShouldBeCleared() {
        assertTrue(chargingStationsListPage.isSearchFieldEmpty());
    }

    @When("I click on the Map View icon")
    public void iClickOnTheMapViewIcon() {
        chargingStationsListPage.mapView();
    }

    @Then("the Search Charging Stations Map page should be opened")
    public void theSearchChargingStationsMapPageShouldBeOpened() {
        assertTrue(searchChargingStationsMapPage.mapViewIsOnPage());
    }


    @When("I click on the More Info button of a Charging Station {string}")
    public void iClickOnTheMoreInfoButtonOfAChargingStation(String csName) {
        chargingStationsListPage.clcikMoreInfoButton(csName);
    }

    @Then("the Charge Point Charging Station page should be opened")
    public void theChargePointChargingStationPageShouldBeOpened() {

    }


    @When("user clicks on the Heartbeat icon of a Charging Station {string}")
    public void userClicksOnTheHeartbeatIconOfAChargingStation(String csname) {
        chargingStationsListPage.clickHeartbeatBtn(csname);
    }

    @Then("the Charging Station status should be displayed")
    public void theChargingStationStatusShouldBeDisplayed() {
        assertTrue(chargingStationsListPage.heartBeatIsOnPage());

    }
}
