package steps.organization.manageOrg;

import PageObjects.AlertDialogs.EditOrganizationdialog;
import PageObjects.AlertDialogs.NoOrganizationFound;
import PageObjects.organization.ManageOrganizationPage;
import PageObjects.AlertDialogs.AddAnOrganizationDialog;
import PageObjects.login.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoSuchElementException;
import org.testng.ITestContext;
import tests.base.BaseTests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ManageOrganizationPageSteps extends BaseTests {
    ManageOrganizationPage manageOrganizationPage = new ManageOrganizationPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    AddAnOrganizationDialog addAnOrganizationDialog = new AddAnOrganizationDialog(driver);
    EditOrganizationdialog editOrganizationdialog = new EditOrganizationdialog(driver);
    NoOrganizationFound noOrganizationFound = new NoOrganizationFound(driver);

    @Before("@add_organization_from_plus_button or( @delete_org  or (@select_org or @update_org))")
    public void move_to_organization_page() {
        loginPage.clickOragnizationButton();
        System.out.println("before works");
    }

    @After(value = "not  @select_org")
    public void go_back_to_login() {
        manageOrganizationPage.clickBackBtn();
        System.out.println("i m going back");
        System.out.println(driver);

    }

    @Given("User is on the the Add Organization Page")
    public void userIsOnTheTheAddOrganizationPage() {
        assertTrue(manageOrganizationPage.isOnPage());
    }

    @When("User click on the plus button")
    public void the_user_clicks_plus_button() {
        // Write code here that turns the phrase above into concrete actions
        manageOrganizationPage.clickPlusButton();

    }

    @Then("the add organization alert dialog is shown")
    public void add_organization_alert_dialog_is_shown() {

        assertTrue(addAnOrganizationDialog.isOnPage());
        addAnOrganizationDialog.clickCancel();


    }

    @Then("User should be redirected to the login page")
    public void User_should_be_redirected_to_the_login_page() {
        assertTrue(loginPage.isOnPage());
    }


    @When("User pick an {string} and click the update icon")
    public void userPickAnAndClickTheUpdateIcon(String orgName) {
        manageOrganizationPage.Pick_organization(orgName);
        manageOrganizationPage.click_update_btn();
    }

    @And("update dialog and user update {string} and {string}")
    public void updateDialogAndUserUpdateAnd(String newSubDomain, String newName) {

        assertTrue(editOrganizationdialog.isOnPage());
        editOrganizationdialog.updateSubDomainField(newSubDomain);
        editOrganizationdialog.updateNameField(newName);
        editOrganizationdialog.click_save_button();
    }

    @Then("organization {string} and {string} are  updated")
    public void organizationAndAreUpdated(String subdomain, String name) {
        String updatedOrg= subdomain +"("+name+")";
        assertTrue(manageOrganizationPage.org_is_updated(updatedOrg));
    }

    @When("User see organization options and click on the  organization option {string}")
    public void userSeeOrganizationOptionsAndClickOnTheOrganizationOption(String orgOption) {
        manageOrganizationPage.selectOption(orgOption);

    }


    @When("User pick an {string} and click the garbage icon")
    public void userPickAnAndClickTheGarbageIcon(String orgName) {
        manageOrganizationPage.Pick_organization(orgName);
        manageOrganizationPage.delete_organization();
    }

    @Then("{string} should be deleted")
    public void shouldBeDeleted(String orgName) {
        manageOrganizationPage.org_is_deleted(orgName);
    }


}
