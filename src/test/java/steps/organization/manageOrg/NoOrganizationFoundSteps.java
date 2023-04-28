package steps.organization.manageOrg;

import PageObjects.AlertDialogs.NoOrganizationFound;
import PageObjects.login.LoginPage;
import PageObjects.ScanOraganizationPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.ITestContext;
import tests.base.BaseTests;

import java.net.MalformedURLException;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class NoOrganizationFoundSteps extends BaseTests {
    NoOrganizationFound noOrganizationFound = new NoOrganizationFound(driver);
    ScanOraganizationPage ScanOraganizationPage= new ScanOraganizationPage(driver);
    LoginPage LoginPage= new LoginPage(driver);
    @Before("@noORG")
    public  void openApp()
    {
        driver.launchApp();
    }
    @After("@noORG")
    public  void closeApp()
    {
        driver.closeApp();
    }
    @Given("the user has the No Organization Found alert displayed")
    public void theUserHasTheNoOrganizationFoundAlertDisplayed() throws MalformedURLException {
        noOrganizationFound.isOnPage();
        System.out.println("alert is displayed ");
    }
    @When("the user clicks Yes")
    public void the_user_clicks_yes() {
        noOrganizationFound.clickYes();
    }
    @Then("the user is redirected to the QR code scanning page")
    public void theUserIsRedirectedToTheQRCodeScanningPage() {

        assertTrue(ScanOraganizationPage.isOnPage());
    }
    @When("the user clicks Cancel")
    public void the_user_clicks_cancel() {
//        driver.
//// noOrganizationFound.reset();
        // Write code here that turns the phrase above into concrete actions
        noOrganizationFound.clickCancel();

    }
    @Then("the alert is dismissed and the user redirected to the login page")
    public void theAlertIsDismissedAndTheUserRedirectedToTheLoginPage() {

        //assertFalse(noOrganizationFound.isOnPage());
        assertTrue(LoginPage.isOnPage());

    }
    @When("the user clicks the Exit button")
    public void the_user_clicks_existBtn() {
//       noOrganizationFound.reset();
        // Write code here that turns the phrase above into concrete actions
        noOrganizationFound.clickExitButton();
//        throw new io.cucumber.java.PendingException();
        }
    @Then("the alert is dismissed and the user redirected to login page")
    public void TheUserRedirectedToTheLoginPage() {

        //assertFalse(noOrganizationFound.isOnPage());
        assertTrue(LoginPage.isOnPage());
//        throw new io.cucumber.java.PendingException();
    }

    @Override
    public
    void onStart ( ITestContext context ) {

    }
}
