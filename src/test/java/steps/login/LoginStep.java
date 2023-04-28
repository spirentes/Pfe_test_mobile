package steps.login;
import PageObjects.login.LoginPage;
import PageObjects.navbar.NavSidebarMenuPage;
import PageObjects.SearchChargingStationsMapPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.ITestContext;
import tests.base.BaseTests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class LoginStep extends BaseTests {
    LoginPage loginPage= new LoginPage(driver);
    SearchChargingStationsMapPage searchChargingStationsMapPage =new SearchChargingStationsMapPage(driver);
    NavSidebarMenuPage navSidebarMenuPage = new NavSidebarMenuPage(driver);
   @After("@Successful_login")
   public void log_out(){
       searchChargingStationsMapPage.clickNavBarBtn();
       navSidebarMenuPage.logOUt();
   }
    @Given("User is on the login page")
    public void User_is_on_the_login_page(){
        assertTrue(loginPage.isOnPage());
    }

    @When("User enters {string} and {string}")
    public void user_Enters_email_and_password(String email, String password) {
        loginPage.setEmail(email);
        loginPage.setPassword(password);
    }

    @And("User accepts the terms")
    public void userAcceptsTheTerms() {
        loginPage.acceptConditions();
    }

    @And("User clicks on the login button")
    public void userClicksOnTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("User should be redirected to the search charging stations map page")
    public void userShouldBeRedirectedToTheSearchChargingStationsMapPage() {
        assertTrue(searchChargingStationsMapPage.isOnPage());
    }

    @And("User does not accepts the terms")
    public void userDoesNotAcceptsTheTerms() {
        assertFalse(loginPage.check_accept_conditions());
    }

    @Then("User should see an error message indicating that he must accept terms and conditions")
    public void userShouldSeeAnErrorMessageIndicatingThatHeMustAcceptTermsAndConditions() {
        String actual = loginPage.get_terms_error_message();
        String expected1="You must accept the End-User License Agreement";
        String expected2="le message en fr" ;
        System.out.println(actual);
        assertTrue(actual.equals(expected1) || actual.equals(expected2),"does not match ");
    }

    @Then("User should see an error message for Wrong email or password")
    public void userShouldSeeAnErrorMessageForWrongEmailOrPassword() {
        assertTrue(loginPage.isOnPage());
    }

    @Then("User should see an error message for indicating that the email is invalid")
    public void userShouldSeeAnErrorMessageForIndicatingThatTheEmailIsInvalid() {
        String actual = loginPage.get_email_error_message();
        String expected1="The email is invalid";
        String expected2="le message en fr" ;
        System.out.println(actual);
        assertTrue(actual.equals(expected1) || actual.equals(expected2),"does not match ");
    }

    @Override
    public
    void onStart ( ITestContext context ) {

    }
}

