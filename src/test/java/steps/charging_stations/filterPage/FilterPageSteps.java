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

import static org.testng.Assert.assertTrue;

public class FilterPageSteps extends BaseTests {
    SearchChargingStationsMapPage searchChargingStationsMapPage = new SearchChargingStationsMapPage(driver);
    ChargingStationsListPage chargingStationsListPage = new ChargingStationsListPage(driver);
    FiltersPage filtersPage = new FiltersPage(driver);
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
        if (searchChargingStationsMapPage.mapViewIsOnPage()) {
            System.out.println("first if  ");
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
        } else if (chargingStationsListPage.isOnPage()) {
            System.out.println("second if");
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

        }
    }

    @When("user clicks on roaming charging stations button")
    public void userClicksOnRoamingChargingStationsButton() {
        filtersPage.clickShowRoamingCS();
    }

    @Then("{string} should be displayed")
    public void shouldBeDisplayed(String roaming_CS) throws IOException{
        List<String> roaming_CSs = Arrays.asList(roaming_CS.split("\\s*,\\s*"));
        if (searchChargingStationsMapPage.mapViewIsOnPage()) {
            System.out.println("first if  ");
            for (String roamingCs : roaming_CSs) {
                System.out.println(roamingCs);
                try {
                    assertTrue(searchChargingStationsMapPage.charging_station_is_on_map(roamingCs));
                    assertTrue(searchChargingStationsMapPage.CS_is_available(roamingCs));
                }
                catch (AssertionError e)
                {
                    assertTrue(filtersPage.noCsFound_id_displayed());
                }

            }

        } else if (chargingStationsListPage.isOnPage()) {
            System.out.println("second if");
            for (String roamingCs : roaming_CSs) {
                System.out.println(roamingCs);

                try {
                    assertTrue(chargingStationsListPage.isCSDisplayed(roamingCs));
                }
                catch (AssertionError e)
                {
                    assertTrue(filtersPage.noCsFound_id_displayed());
                }
            }

        }

    }

    @When("user choose charging station connector type {string}")
    public void userChooseChargingStationConnectorType(String type) {
        filtersPage.select_connector_type(type);
    }


    @Then("charging stations with selected {string} should be displayed")
    public void chargingStationsWithSelectedShouldBeDisplayed(String type) {
        assertTrue(filtersPage.only_cs_with_specified_connector_type_are_displayed(type));
    }


    @When("user choose Multiple charging station connector types {string} and {string}")
    public void userChooseMultipleChargingStationConnectorTypesAnd(String type1, String type2) {
        filtersPage.select_connector_type(type1);
        filtersPage.select_connector_type(type2);
    }


    @Then("{string} with selected {string}and {string} should be displayed")
    public void withSelectedAndShouldBeDisplayed(String CS, String type1, String type2) {
        List<String> CSs = Arrays.asList(CS.split("\\s*,\\s*"));
        if(chargingStationsListPage.isOnPage())
        { assertTrue(filtersPage.cs_with_specified_connectors_type_are_displayed(type1,type2));}
        for (String cs : CSs)
        {
            searchChargingStationsMapPage.tap_on_cs(cs);
            assertTrue(filtersPage.cs_with_specified_connectors_type_are_displayed(type1,type2));
        }

    }
}

