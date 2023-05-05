package steps.charging_stations.mapView;

import PageObjects.charging_stations.ActionsChargingStationsPage;
import PageObjects.charging_stations.ChargingStationsListPage;
import PageObjects.charging_stations.InfoChargingStationsPage;
import PageObjects.charging_stations.SearchChargingStationsMapPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.base.BaseTests;

import java.io.IOException;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
public class ChargingstationsMapPageSteps extends BaseTests {
    SearchChargingStationsMapPage searchChargingStationsMapPage= new SearchChargingStationsMapPage(driver);
    ChargingStationsListPage chargingStationsListPage = new ChargingStationsListPage(driver);
    ActionsChargingStationsPage actionsChargingStationsPage= new ActionsChargingStationsPage(driver);
    InfoChargingStationsPage infoChargingStationsPage=new InfoChargingStationsPage(driver);
    @After("@properties")
    public void goBackFromProperties(){
        driver.navigate().back();
        driver.navigate().back();
    }

    @After("@ocpp")
    public void goBackFromOcpp(){
        driver.navigate().back();
        driver.navigate().back();
    }
    //    @After("@inactive , @active")
//    public  void goBacktoMappage(){
//        driver.navigate().back();
//    }
    @Given("user is  on the Charging Stations map page")
    public void userIsOnTheChargingStationsMapPage() throws FindFailed {
        assertTrue(searchChargingStationsMapPage.mapViewIsOnPage());
    }
    @Then("the charging stations {string} should be  plotted on a map")
    public void theChargingStationsShouldBePlottedOnAMap(String CSname) {

        assertTrue(searchChargingStationsMapPage.charging_station_is_on_map(CSname));
    }

    @When("user clicks on the satellite view icon")
    public void userClicksOnTheSatelliteViewIcon() {
        searchChargingStationsMapPage.clickSatelliteViewIcon();
    }

    @Then("the charging stations satellite  map page should be displayed")
    public void theChargingStationsSatelliteMapPageShouldBeDisplayed() {
        assertTrue(searchChargingStationsMapPage.isOnPage());
    }

    @When("user clicks on the list view icon")
    public void userClicksOnTheListViewIcon() {
        searchChargingStationsMapPage.clickListViewIcon();
    }

    @Then("the charging stations list page should be displayed")
    public void theChargingStationsListPageShouldBeDisplayed() {
        assertTrue(chargingStationsListPage.isOnPage());
    }

    @When("User search for a Charging Station with cs name {string}")
    public void userSearchForAChargingStationWithCsName(String csName) {
        chargingStationsListPage.searchForCS(csName);
    }

    @Then("the Charging Station with name {string} should be displayed on the map")
    public void theChargingStationWithNameShouldBeDisplayedOnTheMap(String csName) {
        assertTrue(searchChargingStationsMapPage.charging_station_is_on_map(csName));
        searchChargingStationsMapPage.clearSearchField();
    }





    @When("Charging Station {string} is not active")
    public void chargingStationIsNotAvailable(String csName) throws IOException {
        assertFalse(searchChargingStationsMapPage.CS_is_available(csName));
    }
    @And("User tap on the Charging Station icon {string}")
    public void userTapOnTheChargingStationIcon(String csName) throws IOException {
        searchChargingStationsMapPage.tap_on_cs(csName);

    }

    @Then("{string},unavailable connector message ,red heartbeat,power consumption should be displayed and user can not perform any action")
    public void unavailableConnectorMessageRedHeartbeatPowerConsumptionShouldBeDisplayedAndUserCanNotPerformAnyAction(String csName) {
        assertTrue(searchChargingStationsMapPage.cs_name_is_displayed(csName));
        assertTrue(searchChargingStationsMapPage.ConnectorAvailability_is_displayed());
        assertTrue(searchChargingStationsMapPage.connector_type_is_displayed());
        assertTrue(searchChargingStationsMapPage.heartbeat_is_displayed());
        searchChargingStationsMapPage.click_more_info_btn();
        assertFalse(actionsChargingStationsPage.areActionsEnabled());

    }


    @When("Charging Station {string} is  active")
    public void chargingStationIsAvailable(String csName) throws IOException {
        assertTrue(searchChargingStationsMapPage.CS_is_available(csName));
    }

    @Then("{string},unavailable connector message ,red heartbeat,power consumption should be displayed and user can  perform any action")
    public void unavailableConnectorMessageRedHeartbeatPowerConsumptionShouldBeDisplayedAndUserCanPerformAnyAction(String csName) {
        assertTrue(searchChargingStationsMapPage.cs_name_is_displayed(csName));
        assertTrue(searchChargingStationsMapPage.ConnectorAvailability_is_displayed());
        assertTrue(searchChargingStationsMapPage.connector_type_is_displayed());
        assertTrue(searchChargingStationsMapPage.heartbeat_is_displayed());
        searchChargingStationsMapPage.click_more_info_btn();
        assertTrue(actionsChargingStationsPage.areActionsEnabled());
    }
    @And("user clicks more info button")
    public void userClicksMoreInfoButton() {
        searchChargingStationsMapPage.click_more_info_btn();
    }
    @And("user clicks on ocpp icon")
    public void userClicksOnOcppIcon() {

        actionsChargingStationsPage.clickMoveToOCPP();
    }

    @Then("the charging stations ocpp parameters should be displayed")
    public void theChargingStationsOcppParametersShouldBeDisplayed() {
        assertTrue(actionsChargingStationsPage.ocpp_param_are_displayed());
    }
    @And("user clicks on properties icon")
    public void userClicksOnPropertiesIcon() {
        actionsChargingStationsPage.clickMoveToProperties();
    }
    @Then("the charging stations  properties should be displayed")
    public void theChargingStationsPropertiesShouldBeDisplayed() {
        assertTrue(infoChargingStationsPage.properties_are_displayed());
    }


}