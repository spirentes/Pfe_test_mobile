package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertTrue;
import PageObjects.NavSidebarMenuPage;
import tests.base.BaseTests;

import java.net.MalformedURLException;

public class NavSidebarMenuStepDefs  extends BaseTests {

    private NavSidebarMenuPage navSidebarMenuPage;

    @Given("the user is on the navigation sidebar menu page")
    public void userIsOnNavSidebarMenuPage() throws MalformedURLException {
        configureAppium();
        
        navSidebarMenuPage = new NavSidebarMenuPage(driver);
        assertTrue(navSidebarMenuPage.isOnPage());
    }

    @When("the user clicks the QR code scanner button")
    public void userClicksQRCodeScanner() {
        navSidebarMenuPage.clickQRCodeScanner();
    }

    @When("the user clicks the sites button")
    public void userClicksSites() {
        navSidebarMenuPage.clickSites();
    }

    @When("the user clicks the charging stations button")
    public void userClicksChargingStations() {
        navSidebarMenuPage.clickChargingStations();
    }

    @When("the user clicks the sessions history button")
    public void userClicksSessionsHistory() {
        navSidebarMenuPage.clickSessionsHistory();
    }

    @When("the user clicks the sessions in progress button")
    public void userClicksSessionsInProgress() {
        navSidebarMenuPage.clickSessionsInProgress();
    }

    @When("the user clicks the statistics button")
    public void userClicksStatistics() {
        navSidebarMenuPage.clickStatistics();
    }

    @When("the user clicks the users button")
    public void userClicksUsers() {
        navSidebarMenuPage.clickUsers();
    }

    @When("the user clicks the RFID cards button")
    public void userClicksRFIDCards() {
        navSidebarMenuPage.clickRFIDCards();
    }

    @When("the user clicks the payment methods button")
    public void userClicksPaymentMethods() {
        navSidebarMenuPage.clickPaymentMethods();
    }

    @When("the user clicks the invoices button")
    public void userClicksInvoices() {
        navSidebarMenuPage.clickInvoices();
    }

    @Then("the corresponding page should be displayed")
    public void correspondingPageIsDisplayed() {
        assertTrue(navSidebarMenuPage.isOnPage());
    }
}
