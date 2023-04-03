package steps.navBar;

import PageObjects.LoginPage;
import PageObjects.NavSidebarMenuPage;
import PageObjects.SearchChargingStationsMapPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.base.BaseTests;

import java.net.MalformedURLException;

import static org.testng.Assert.assertTrue;

public
class LogOutStepDefs  extends BaseTests {
    LoginPage loginPage ;
    NavSidebarMenuPage navSidebarMenuPage;



    @When ("the user clicks the log out button")
    public void userClicksLogOut() {
        navSidebarMenuPage = new NavSidebarMenuPage(driver);
        navSidebarMenuPage.logOUt ();
    }
    @Then ("User should be taken to the login page")
    public
    void userShouldBeTakenToTheLoginPage ( ) {
        loginPage = new LoginPage ( driver );
        assertTrue ( loginPage.isOnPage());
    }
}
