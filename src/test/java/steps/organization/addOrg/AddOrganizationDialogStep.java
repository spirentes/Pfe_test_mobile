package steps.organization.addOrg;

import PageObjects.AlertDialogs.RegisterOrSginInDialog;
import PageObjects.login.LoginPage;
import PageObjects.organization.ManageOrganizationPage;
import PageObjects.AlertDialogs.AddAnOrganizationDialog;
import PageObjects.AlertDialogs.AddOrganizationManuallyDialog;
import PageObjects.organization.ScanOraganizationPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.base.BaseTests;

import java.net.MalformedURLException;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class AddOrganizationDialogStep extends BaseTests {
    //AndroidDriver driver= ManageOrganizationPageSteps.driver;
    AddAnOrganizationDialog addAnOrganizationDialog = new AddAnOrganizationDialog(driver);
    ScanOraganizationPage scanOraganizationPage = new ScanOraganizationPage(driver);
    AddOrganizationManuallyDialog addOrganizationManuallyDialog = new AddOrganizationManuallyDialog(driver);
    ManageOrganizationPage manageOrganizationPage =new ManageOrganizationPage(driver) ;
    RegisterOrSginInDialog registerOrSginInDialog=new RegisterOrSginInDialog(driver) ;

    LoginPage loginPage =new LoginPage(driver);
    public static String organizationName;
    @Before()
    public void move_to_organization_page() {
        loginPage.clickOragnizationButton();
        manageOrganizationPage.clickPlusButton();
        System.out.println("before works");
    }
    @After("@scanOrg")
    public void afterScan(){
        driver.navigate().back();
        driver.navigate().back();

    }
    @After("@successful_creation")
    public void afterSuccessful(){
        driver.navigate().back();
        driver.navigate().back();

    }
    @After("@failed_creation")
    public void afterFailed(){
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();

    }

    @Given("User is on Add an Organization dialog")
    public void userIsOnAddAnOrganizationDialog()  {

        assertTrue(addAnOrganizationDialog.isOnPage());
    }

    @When("User clicks on the QR code button")
    public void userClicksOnTheQRCodeButton() {
        addAnOrganizationDialog.click_QR_code();
    }

    @Then("QR code scanner is activated")
    public void qrCodeScannerIsActivated() {
        assertTrue(scanOraganizationPage.isOnPage());
       // scanOraganizationPage.return_to_organizations_page();
    }

    @When("User clicks on the manually button")
    public void userClicksOnTheManuallyButton() {
        addAnOrganizationDialog.clickManually();
    }
    @And("User is redirected to the manual organization page")
    public void userIsRedirectedToTheManualOrganizationPage() {
        assertTrue(addOrganizationManuallyDialog.isOnPage());

    }
    @And("User   enters {string} and {string}")
    public void userEntersAnd(String SubDomain , String Name) {
        organizationName=Name;
        addOrganizationManuallyDialog.setSubDomainField(SubDomain);
        addOrganizationManuallyDialog.setNameField(Name);
    }
    @And("User clicks on the create button")
    public void userClicksOnTheCreateButton() {
        addOrganizationManuallyDialog.click_create_button();
    }
    @Then("organization created successfully and a alert dialog is shown asking for registration on logging in")
    public void organizationCreatedSuccessfullyAndAAlertDialogIsShownAskingForRegistrationOnLoggingIn() {
        String expected1 = "THE ORGANIZATION '"+organizationName+"' HAS BEEN ADDED";
        String expected2 = "What would you like to do?";
        String actual = registerOrSginInDialog.get_alert_title();
        //System.out.println(expected1);
        //System.out.println(actual);
        assertTrue(actual.equals(expected1) || actual.equals(expected2),"does not match ");
       // registerOrSginInDialog.click_close_button();
    }
    @Then("red message tell user that  the subdomain is already in use")
    public void redMessageTellUserThatTheSubdomainIsAlreadyInUse() {
        String expected1 = "This subdomain is already used in the organization '"+organizationName+"'";
        String expected2 = "title in french";
        String actual = registerOrSginInDialog.get_error_message();
       // System.out.println(expected1);
       // System.out.println(actual);
        assertTrue(actual.equals(expected1) || actual.equals(expected2),"does not match ");

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
