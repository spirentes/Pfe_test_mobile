package steps.organization;

import PageObjects.organization.ManageOrganizationPage;
import PageObjects.AlertDialogs.AddAnOrganizationDialog;
import PageObjects.AlertDialogs.AddOrganizationManuallyDialog;
import PageObjects.AlertDialogs.RegisterOrSginInDialog;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.base.BaseTests;

import java.net.MalformedURLException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddOrganizationManuallyDialogSteps extends BaseTests {
    AddOrganizationManuallyDialog addOrganizationManuallyDialog;
    RegisterOrSginInDialog registerOrSginInDialog ;
    public static String organizationName;

    @Given("User is on Add an Organization Manually dialog")
    public void user_is_on_add_an_organization_manually_dialog() throws MalformedURLException {
        //configureAppium();
        addOrganizationManuallyDialog =new AddOrganizationManuallyDialog(driver);
        assertTrue(addOrganizationManuallyDialog.isOnPage());
    }
    @When("User enters {string} and {string}")
    public void userEntersAnd(String SubDomain , String Name) {
        organizationName=Name;
        addOrganizationManuallyDialog.setSubDomainField(SubDomain);
        addOrganizationManuallyDialog.setNameField(Name);

    }
    @And("User clicks on the create button")
    public void User_clicks_on_the_create_button() {
        addOrganizationManuallyDialog.click_create_button();
    }
    @Then("organization created successfully and a alert dialog is shown asking for registration on logging in" )
    public void AlertDialog_Shown() {
        registerOrSginInDialog = new RegisterOrSginInDialog(driver);
        String expected1 = "THE ORGANIZATION '"+organizationName+"' HAS BEEN ADDED";
        String expected2 = "What would you like to do?";
        String actual = registerOrSginInDialog.get_alert_title();
        //System.out.println(expected1);
        //System.out.println(actual);
        assertTrue(actual.equals(expected1) || actual.equals(expected2),"does not match ");
        registerOrSginInDialog.click_close_button();


    }
    @Before("@failed_creation")
    public void before_failed()
    {
        ManageOrganizationPage addOrganizationPage=new ManageOrganizationPage(driver);
        AddAnOrganizationDialog addAnOrganizationDialog =new AddAnOrganizationDialog(driver);
        addOrganizationPage.clickPlusButton();
        addAnOrganizationDialog.clickManually();
    }
    @Then("red message tell user that  the subdomain is already in use" )
    public void Red_Message_Shown() {
        registerOrSginInDialog = new RegisterOrSginInDialog(driver);
        String expected1 = "This subdomain is already used in the organization '"+organizationName+"'";
        String expected2 = "title in french";
        String actual = registerOrSginInDialog.get_error_message();
       // System.out.println(expected1);
       // System.out.println(actual);
        assertTrue(actual.equals(expected1) || actual.equals(expected2),"does not match ");
    }

}
