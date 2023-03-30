package steps.registration;

import PageObjects.LoginPage;
import PageObjects.RegistrationPage;
import PageObjects.SearchChargingStationsMapPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.base.BaseTests;

import java.net.MalformedURLException;

import static org.testng.Assert.assertTrue;

public class SuccessfulRegistrationSteps extends BaseTests {
    RegistrationPage registrationPage;
    LoginPage loginPage;
    SearchChargingStationsMapPage searchChargingStationsMapPage;
    public static String emailField;

    @Given("User clicks on the new user button")
    public void userClicksOnTheNewUserButton() throws MalformedURLException {
        configureAppium();
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage ( driver );
        searchChargingStationsMapPage=new SearchChargingStationsMapPage(driver);
        registrationPage = loginPage.clickNewUserBtn();

    }

    @When("User enters {string}, {string}, {string}, and {string}")
    public void userEnters(String firstName, String lastName, String email, String password) {
        emailField = email;
        registrationPage.setFirstName(firstName);
        registrationPage.setLastName(lastName);
        registrationPage.setEmail(email);
        registrationPage.setPassword(password);
        registrationPage.setConfirmPassword(password);
    }

    @And("User accepts the terms and conditions")
    public void userAcceptsTheTermsAndConditions() {
        registrationPage.acceptConditions();
    }

    @And("User clicks on the register button")
    public void userClicksOnTheRegisterButton() {
       loginPage = registrationPage.clickRegisterButton ( );
    }

    @Then("User should be registered successfully")
    public void userShouldBeRegisteredSuccessfully() {
        driver.hideKeyboard();
        assertTrue(loginPage.isOnPage());
        // Example objects
        String expected = emailField;
        String actual = loginPage.getEmailFieldText();
        assertTrue(expected.equals(actual));

    }
}
