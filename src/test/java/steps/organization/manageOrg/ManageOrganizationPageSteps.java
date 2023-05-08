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
    ManageOrganizationPage manageOrganizationPage= new ManageOrganizationPage ( driver );
    LoginPage loginPage = new LoginPage(driver);
    AddAnOrganizationDialog addAnOrganizationDialog =new AddAnOrganizationDialog ( driver );
    EditOrganizationdialog editOrganizationdialog= new EditOrganizationdialog ( driver );
    NoOrganizationFound  noOrganizationFound= new NoOrganizationFound ( driver );
@Before( "@add_organization_from_plus_button or( @delete_org  or (@select_org or @update_org))")
public  void move_to_organization_page()
{


    loginPage.clickOragnizationButton ( );
    System.out.println ( "hiiiiiiiiiiiii" );
}

    @After(value = "not  @select_org")
    public void go_back_to_login()

    {   driver.navigate ().back ();
        driver.navigate ().back ();
        System.out.println("i m going back");
        System.out.println ( driver );

    }
    @Given("User is on the the Add Organization Page")
    public void userIsOnTheTheAddOrganizationPage()  {
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
       addAnOrganizationDialog.clickCancel ();



    }

    @Then("User should be redirected to the login page")
    public void User_should_be_redirected_to_the_login_page() {

        assertTrue(loginPage.isOnPage());
    }

    @When("User pick an organization and click the garbage icon")
    public void delete_organization()
    {
        manageOrganizationPage.delete_organization();
    }
    @Then("organization should be deleted")
    public void organization_should_be_deleted()
    { System.out.println ( "deleted" );
       // assertFalse(manageOrganizationPage.organizationOption1.isDisplayed());
    }

    @When("User pick an organization and click the update icon")
    public void userPickAnOrganizationAndClickTheUpdateIcon() {

        manageOrganizationPage.update_organization();
    }
    @And("update dialog and user update {string} and {string}")
    public void updateDialogAndUserUpdateAnd(String newSubDomain, String newName) {

        assertTrue(editOrganizationdialog.isOnPage());
        editOrganizationdialog.updateSubDomainField(newSubDomain);
        editOrganizationdialog.updateNameField(newName);
        editOrganizationdialog.click_save_button();
    }
    @Then("organization is updated")
    public void organization_is_updated () {
System.out.println("bravoooo");

    }

    @When ("User see organization options and click on the  organization option {string}")
    public
    void userSeeOrganizationOptionsAndClickOnTheOrganizationOption ( String orgOption ) {
    manageOrganizationPage.selectOption ( orgOption );

    }


//    @Override
//    public
//    void onStart ( ITestContext context ) {
//
//    }
}
