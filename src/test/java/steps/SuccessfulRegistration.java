package steps;

import PageObjects.LoginPage;
import PageObjects.RegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.base.BaseTests;

import java.net.MalformedURLException;

public class SuccessfulRegistration extends BaseTests {
    RegistrationPage registrationPage;
    LoginPage loginPage;

    @Given("User clicks on the new user button")
    public void userClicksOnTheNewUserButton() throws MalformedURLException {
        configureAppium();
        loginPage = new LoginPage(driver);
        registrationPage = loginPage.clickNewUserBtn();

    }

    @When("User enters {string}, {string}, {string}, and {string}")
    public void userEnters(String firstName, String lastName, String email, String password) {
        registrationPage.setLastName(lastName);
        registrationPage.setFirstName(firstName);
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
        loginPage = registrationPage.clickRegisterButton();
    }

    @Then("User should be registered successfully")
    public void userShouldBeRegisteredSuccessfully() {
        driver.hideKeyboard();
        // Add assertions for successful registration
    }
}
