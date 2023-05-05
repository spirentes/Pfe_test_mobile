package steps.organization;

import PageObjects.organization.ManageOrganizationPage;
import PageObjects.AlertDialogs.AddAnOrganizationDialog;
import PageObjects.AlertDialogs.AddOrganizationManuallyDialog;
import PageObjects.organization.ScanOraganizationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.base.BaseTests;

import java.net.MalformedURLException;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class AddOrganizationDialogStep extends BaseTests {
    //AndroidDriver driver= ManageOrganizationPageSteps.driver;
    AddAnOrganizationDialog addAnOrganizationDialog;
    ScanOraganizationPage scanOraganizationPage;
    AddOrganizationManuallyDialog addOrganizationManuallyDialog;
    ManageOrganizationPage addOrganizationPage ;
    @Given("User is on Add an Organization dialog")
    public void userIsOnAddAnOrganizationDialog() throws MalformedURLException {
       // configureAppium();
        addAnOrganizationDialog = new AddAnOrganizationDialog(driver);
        assertTrue(addAnOrganizationDialog.isOnPage());
    }

    @When("User clicks on the QR code button")
    public void userClicksOnTheQRCodeButton() {
        addAnOrganizationDialog.click_QR_code();
    }

    @Then("QR code scanner is activated")
    public void qrCodeScannerIsActivated() {
        scanOraganizationPage = new ScanOraganizationPage(driver);
        addOrganizationPage  = new ManageOrganizationPage(driver);
        assertTrue(scanOraganizationPage.isOnPage());
        scanOraganizationPage.return_to_organizations_page();
        addOrganizationPage.clickPlusButton();

    }

    @When("User clicks on the manually button")
    public void userClicksOnTheManuallyButton() {
        addAnOrganizationDialog.clickManually();
    }

    @Then("User is redirected to the manual organization page")
    public void userIsRedirectedToTheManualOrganizationPage() {
        addOrganizationManuallyDialog= new AddOrganizationManuallyDialog(driver);
        assertTrue(addOrganizationManuallyDialog.isOnPage());
        addOrganizationManuallyDialog.click_back_button();

    }

    @When("User clicks on the cancel button")
    public void userClicksOnTheCancelButton() {
        addAnOrganizationDialog.clickCancel();
    }

    @Then("Add an Organization dialog is closed")
    public void addAnOrganizationDialogIsClosed() {
        addOrganizationPage  = new ManageOrganizationPage(driver);
        assertFalse(addAnOrganizationDialog.isOnPage());
        assertTrue(addOrganizationPage.isOnPage());
        addOrganizationPage.clickPlusButton();
    }

    @When("User clicks on the exist button")
    public void userClicksOnTheExistButton() {
        addAnOrganizationDialog.clickExistBtn();
    }

    @Then("add Organization dialog is closed")
    public void addOrganizationDialogIsClosed() {
        addOrganizationPage  = new ManageOrganizationPage(driver);
        //assertFalse(addAnOrganizationDialog.isOnPage());
        assertTrue(addOrganizationPage.isOnPage());
    }
}
