package steps.organization.noOrgFound;

import PageObjects.AlertDialogs.NoOrganizationFound;
import PageObjects.login.LoginPage;
import PageObjects.organization.ScanOraganizationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.base.BaseTests;

import java.net.MalformedURLException;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class NoOrganizationFoundSteps extends BaseTests {
    NoOrganizationFound noOrganizationFound ;
    ScanOraganizationPage ScanOraganizationPage;
    LoginPage LoginPage;
    @Given("the user has the No Organization Found alert displayed")
    public void theUserHasTheNoOrganizationFoundAlertDisplayed() throws MalformedURLException {
        configureAppium();
        noOrganizationFound = new NoOrganizationFound(driver);
        ScanOraganizationPage = new ScanOraganizationPage(driver);
        noOrganizationFound.isOnPage();
        System.out.println("alert is displayed ");
    }
    @When("the user clicks Yes")
    public void the_user_clicks_yes() {
        // Write code here that turns the phrase above into concrete actions
        noOrganizationFound.clickYes();
        //throw new io.cucumber.java.PendingException();
    }
    @Then("the user is redirected to the QR code scanning page")
    public void theUserIsRedirectedToTheQRCodeScanningPage() {
        assertTrue(ScanOraganizationPage.isOnPage());
    }
    @When("the user clicks Cancel")
    public void the_user_clicks_cancel() {
        noOrganizationFound.reset();
        // Write code here that turns the phrase above into concrete actions
        noOrganizationFound.clickCancel();
        //throw new io.cucumber.java.PendingException();
    }
    @Then("the alert is dismissed and the user redirected to the login page")
    public void theAlertIsDismissedAndTheUserRedirectedToTheLoginPage() {
        LoginPage = new LoginPage(driver);
        //assertFalse(noOrganizationFound.isOnPage());
        assertTrue(LoginPage.isOnPage());
    }
    @When("the user clicks the Exit button")
    public void the_user_clicks_existBtn() {
        noOrganizationFound.reset();
        // Write code here that turns the phrase above into concrete actions
        noOrganizationFound.clickExitButton();
        //throw new io.cucumber.java.PendingException();
        }
    @Then("the alert is dismissed and the user redirected to login page")
    public void TheUserRedirectedToTheLoginPage() {
        LoginPage = new LoginPage(driver);
        //assertFalse(noOrganizationFound.isOnPage());
        assertTrue(LoginPage.isOnPage());
    }
}
