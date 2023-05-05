package steps.charging_stations.listView;

import PageObjects.charging_stations.ActionsChargingStationsPage;
import PageObjects.charging_stations.ChargingStationsListPage;
import PageObjects.charging_stations.ScanChargingStations;
import PageObjects.charging_stations.SearchChargingStationsMapPage;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.C;
import org.json.simple.parser.ParseException;
import tests.base.BaseTests;

import java.io.IOException;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ChargingstationsListPageSteps extends BaseTests {
    SearchChargingStationsMapPage searchChargingStationsMapPage= new SearchChargingStationsMapPage(driver);
    ChargingStationsListPage chargingStationsListPage = new ChargingStationsListPage(driver);
    ActionsChargingStationsPage actionsChargingStationsPage=new ActionsChargingStationsPage(driver);
    ScanChargingStations scanChargingStations = new ScanChargingStations(driver);

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

    @Then("the  Charging Station actions page should be opened")
    public void theChargePointChargingStationPageShouldBeOpened() {
       assertTrue(actionsChargingStationsPage.isOnPage());
    }


    @When("user clicks on the Heartbeat icon of a Charging Station {string}")
    public void userClicksOnTheHeartbeatIconOfAChargingStation(String csname) {
        chargingStationsListPage.clickHeartbeatBtn(csname);
    }

    @Then("the Charging Station status should be displayed")
    public void theChargingStationStatusShouldBeDisplayed() {
        assertTrue(chargingStationsListPage.heartBeatIsOnPage());
        driver.navigate().back();

    }

    @When("Charging Station {string} is not  active")
    public void chargingStationIsNotActive(String csName) throws IOException {
        assertFalse(chargingStationsListPage.CS_is_available(csName));
    }

    @And("User clicks on more info button {string}")
    public void userClicksOnMoreInfoButton(String csName) {
        chargingStationsListPage.clcikMoreInfoButton(csName);
    }

    @Then("user can not perform any action on {string}")
    public void userCanNotPerformAnyActionOn(String arg0) {
        assertFalse(chargingStationsListPage.areActionsEnabled());
    }

    @When("User click on the Scan Charging Stations button")
    public void userClickOnTheScanChargingStationsButton() {
        chargingStationsListPage.scanChargingStation();
    }

    @And("user scan a valid {string}")
    public void userScanAValid(String path) throws ChecksumException, NotFoundException, IOException, FormatException, WriterException, ParseException {
        //String CSID =scanChargingStations.qrCodeContent(path);
        scanChargingStations.getChargingStationById("dv");
    }
    @Then("a news charging station")
    public void aNewsChargingStation() {
        System.out.println("point charge should be opened");
    }
}
