package steps.charging_stations.filterPage;

import PageObjects.charging_stations.ChargingStationsListPage;
import PageObjects.charging_stations.FiltersPage;
import PageObjects.charging_stations.SearchChargingStationsMapPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import tests.base.BaseTests;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class FilterPageSteps extends BaseTests {
    SearchChargingStationsMapPage searchChargingStationsMapPage = new SearchChargingStationsMapPage(driver);
    ChargingStationsListPage chargingStationsListPage = new ChargingStationsListPage(driver);
    FiltersPage filtersPage = new FiltersPage(driver);
    enum PageType {
        MAP_VIEW, LIST_VIEW
    }
    private PageType getCurrentPage() {
        if (searchChargingStationsMapPage.mapViewIsOnPage()) {
            return PageType.MAP_VIEW;
        } else if (chargingStationsListPage.isOnPage()) {
            return PageType.LIST_VIEW;
        } else {
            throw new IllegalStateException("Unknown page");
        }
    }
    @Before//("@available")
    public void openFilterPage ()
    {
        try {
            searchChargingStationsMapPage.clickFilterIcon();
            filtersPage.clickClear();
        }
        catch (TimeoutException e)
        {
            searchChargingStationsMapPage.clickFullFilterIcon();
            filtersPage.clickClear();
        }
    }


    @Given("User is  on the Charging Stations filer Page")
    public void userIsOnNavSidebarMenuPage() throws MalformedURLException {
        assertTrue(filtersPage.isOnPage());

    }

    @When("user clicks on available charging stations button")
    public void userClickOnAvailableChargingStationsButton() {
        filtersPage.clickAvailableCS();
    }

    @And("user clicks on apply button")
    public void userClicksOnApplyButton() {
        filtersPage.clickApply();
    }

    @Then("only available {string} should be displayed")
    public void onlyAvailableShouldBeDisplayed(String csnames) throws IOException {
        List<String> csNames = Arrays.asList(csnames.split("\\s*,\\s*"));
        switch (getCurrentPage()) {
            case MAP_VIEW:
                for (String csName : csNames) {
                    System.out.println(csName);
                    try {
                        assertTrue(searchChargingStationsMapPage.charging_station_is_on_map(csName));
                        assertTrue(searchChargingStationsMapPage.CS_is_available(csName));
                    }
                    catch (AssertionError e)
                    {
                        assertTrue(filtersPage.noCsFound_id_displayed());
                    }

                }
                searchChargingStationsMapPage.clickListViewIcon();
                for (String csName : csNames) {
                System.out.println(csName);

                try {
                    assertTrue(chargingStationsListPage.isCSDisplayed(csName));
                }
                catch (AssertionError e)
                {
                    assertTrue(filtersPage.noCsFound_id_displayed());
                }
            }

                break;
            case LIST_VIEW:
                for (String csName : csNames) {
                    System.out.println(csName);

                    try {
                        assertTrue(chargingStationsListPage.isCSDisplayed(csName));
                    }
                    catch (AssertionError e)
                    {
                        assertTrue(filtersPage.noCsFound_id_displayed());
                    }
                }
                chargingStationsListPage.mapView();
                for (String csName : csNames) {
                    System.out.println(csName);
                    try {
                        assertTrue(searchChargingStationsMapPage.charging_station_is_on_map(csName));
                        assertTrue(searchChargingStationsMapPage.CS_is_available(csName));
                    }
                    catch (AssertionError e)
                    {
                        assertTrue(filtersPage.noCsFound_id_displayed());
                    }

                }
                break;
            default:
                throw new IllegalStateException("Unexpected page: " + getCurrentPage());
        }
    }

    @When("user clicks on roaming charging stations button")
    public void userClicksOnRoamingChargingStationsButton() {
        filtersPage.clickShowRoamingCS();
    }

    @Then("{string} should be displayed")
    public void shouldBeDisplayed(String roaming_CS) throws IOException{
        List<String> roaming_CSs = Arrays.asList(roaming_CS.split("\\s*,\\s*"));
        switch (getCurrentPage()) {
            case MAP_VIEW:
                for (String roamingCs : roaming_CSs) {
                System.out.println(roamingCs);
                try {
                    assertTrue(searchChargingStationsMapPage.charging_station_is_on_map(roamingCs));
                    assertTrue(searchChargingStationsMapPage.CS_is_available(roamingCs));
                }
                catch (AssertionError e)
                {
                    assertFalse(searchChargingStationsMapPage.charging_station_is_on_map(roamingCs));
                }
            }
                searchChargingStationsMapPage.clickListViewIcon();
                for (String roamingCs : roaming_CSs ){
                    System.out.println(roamingCs);

                    try {
                        assertTrue(chargingStationsListPage.isCSDisplayed(roamingCs));
                    }
                    catch (AssertionError e)
                    {
                        assertTrue(filtersPage.noCsFound_id_displayed());
                    }
                }

                break;
            case LIST_VIEW:
                for (String roamingCs : roaming_CSs ){
                    System.out.println(roamingCs);

                    try {
                        assertTrue(chargingStationsListPage.isCSDisplayed(roamingCs));
                    }
                    catch (AssertionError e)
                    {
                        assertTrue(filtersPage.noCsFound_id_displayed());
                    }
                }
                chargingStationsListPage.mapView();
                for (String roamingCs : roaming_CSs) {
                    System.out.println(roamingCs);
                    try {
                        assertTrue(searchChargingStationsMapPage.charging_station_is_on_map(roamingCs));
                        assertTrue(searchChargingStationsMapPage.CS_is_available(roamingCs));
                    }
                    catch (AssertionError e)
                    {
                        assertFalse(searchChargingStationsMapPage.charging_station_is_on_map(roamingCs));
                    }
                }
                break;
            default:
                throw new IllegalStateException("Unexpected page: " + getCurrentPage());
        }
    }
    @When("user choose charging station connector type {string}")
    public void userChooseChargingStationConnectorType(String type) {
        filtersPage.select_connector_type(type);
    }


    @Then("charging stations with selected {string} should be displayed")
    public void chargingStationsWithSelectedShouldBeDisplayed(String type) {

        switch (getCurrentPage()) {
            case MAP_VIEW:
                for (WebElement cs: searchChargingStationsMapPage.ChargingStationsOnMap())
                {
                  cs.click();
                  assertTrue(filtersPage.only_cs_with_specified_connector_type_are_displayed(type));
                  searchChargingStationsMapPage.clickExitBtn();
                }
                searchChargingStationsMapPage.clickListViewIcon();
                assertTrue(filtersPage.only_cs_with_specified_connector_type_are_displayed(type));
                break;
            case LIST_VIEW:
                assertTrue(filtersPage.only_cs_with_specified_connector_type_are_displayed(type));
                chargingStationsListPage.mapView();
                for (WebElement cs: searchChargingStationsMapPage.ChargingStationsOnMap())
                {
                    cs.click();
                    assertTrue(filtersPage.only_cs_with_specified_connector_type_are_displayed(type));
                    searchChargingStationsMapPage.clickExitBtn();
                }
                break;
            default:
                throw new IllegalStateException("Unexpected page: " + getCurrentPage());
        }
    }


    @When("user choose Multiple charging station connector types {string} and {string}")
    public void userChooseMultipleChargingStationConnectorTypesAnd(String type1, String type2) {
        filtersPage.select_connector_type(type1);
        filtersPage.select_connector_type(type2);
    }


    @Then("charging stations with selected {string}and {string} should be displayed")
    public void withSelectedAndShouldBeDisplayed( String type1, String type2) {

        switch (getCurrentPage()) {
            case MAP_VIEW:
                for (WebElement cs: searchChargingStationsMapPage.ChargingStationsOnMap())
                {
                    cs.click();
                    assertTrue(filtersPage.cs_with_specified_connectors_type_are_displayed(type1,type2));
                    searchChargingStationsMapPage.clickExitBtn();
                }
                searchChargingStationsMapPage.clickListViewIcon();
                assertTrue(filtersPage.cs_with_specified_connectors_type_are_displayed(type1,type2));
                break;
            case LIST_VIEW:
                assertTrue(filtersPage.cs_with_specified_connectors_type_are_displayed(type1,type2));
                chargingStationsListPage.mapView();
                for (WebElement cs: searchChargingStationsMapPage.ChargingStationsOnMap())
                {
                    cs.click();
                    assertTrue(filtersPage.cs_with_specified_connectors_type_are_displayed(type1,type2));
                    searchChargingStationsMapPage.clickExitBtn();
                }
                break;
            default:
                throw new IllegalStateException("Unexpected page: " + getCurrentPage());
        }
    }
}

