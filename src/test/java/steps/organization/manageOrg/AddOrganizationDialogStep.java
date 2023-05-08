package steps.organization.manageOrg;

import PageObjects.AlertDialogs.NoOrganizationFound;
import PageObjects.login.LoginPage;
import PageObjects.organization.ManageOrganizationPage;
import PageObjects.AlertDialogs.AddAnOrganizationDialog;
import PageObjects.AlertDialogs.AddOrganizationManuallyDialog;
import PageObjects.organization.ScanOraganizationPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoSuchElementException;
import tests.base.BaseTests;

import java.net.MalformedURLException;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class AddOrganizationDialogStep extends BaseTests {

    AddAnOrganizationDialog addAnOrganizationDialog= new AddAnOrganizationDialog(driver);
    ScanOraganizationPage scanOraganizationPage=new ScanOraganizationPage ( driver );
    AddOrganizationManuallyDialog addOrganizationManuallyDialog=new AddOrganizationManuallyDialog ( driver );
    ManageOrganizationPage manageOrganizationPage =new ManageOrganizationPage ( driver );
    LoginPage loginPage =new LoginPage ( driver );
    NoOrganizationFound noOrganizationFound=new NoOrganizationFound ( driver );
    @Before("@DialogOrg")
    public void openAddOrgDialog()
    {  loginPage.clickOragnizationButton();
        System.out.println("hiiiiiiiiiiiii");
        manageOrganizationPage.clickPlusButton();
        try {
            noOrganizationFound.clickCancel ();
            loginPage.clickOragnizationButton();
            System.out.println("hiiiiiiiiiiiii");
            manageOrganizationPage.clickPlusButton();
        } catch ( NoSuchElementException e ) {
            loginPage.clickOragnizationButton();
            System.out.println("hiiiiiiiiiiiii");
            manageOrganizationPage.clickPlusButton();
        }

    }
    @Given("User is on Add an Organization dialog")
    public void userIsOnAddAnOrganizationDialog() throws MalformedURLException {

        assertTrue(addAnOrganizationDialog.isOnPage());
    }

    @When("User clicks on the QR code button")
    public void userClicksOnTheQRCodeButton() {
        addAnOrganizationDialog.click_QR_code();
    }

    @Then("QR code scanner is activated")
    public void qrCodeScannerIsActivated() {
        assertTrue(scanOraganizationPage.isOnPage());
        scanOraganizationPage.return_to_organizations_page();
        manageOrganizationPage.clickPlusButton();

    }

    @When("User clicks on the manually button")
    public void userClicksOnTheManuallyButton() {
        addAnOrganizationDialog.clickManually();
    }

    @Then("User is redirected to the manual organization page")
    public void userIsRedirectedToTheManualOrganizationPage() {
        assertTrue(addOrganizationManuallyDialog.isOnPage());
        addOrganizationManuallyDialog.click_back_button();

    }

    @When("User clicks on the cancel button")
    public void userClicksOnTheCancelButton() {
        addAnOrganizationDialog.clickCancel();
    }

    @Then("Add an Organization dialog is closed")
    public void addAnOrganizationDialogIsClosed() {
        assertFalse(addAnOrganizationDialog.isOnPage());
        assertTrue(manageOrganizationPage.isOnPage());
        manageOrganizationPage.clickPlusButton();
    }

    @When("User clicks on the exist button")
    public void userClicksOnTheExistButton() {
        addAnOrganizationDialog.clickExistBtn();
    }

    @Then("add Organization dialog is closed")
    public void addOrganizationDialogIsClosed() {

        //assertFalse(addAnOrganizationDialog.isOnPage());
        assertTrue(manageOrganizationPage.isOnPage());
    }


}
