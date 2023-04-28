package steps.registration;

import PageObjects.login.LoginPage;
import PageObjects.registration.RegistrationPage;
import PageObjects.SearchChargingStationsMapPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.ITestContext;
import tests.base.BaseTests;

import java.net.MalformedURLException;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class RegistrationSteps extends BaseTests {
    RegistrationPage registrationPage = new RegistrationPage(driver);;
    LoginPage loginPage;
    SearchChargingStationsMapPage searchChargingStationsMapPage ;
    public static String emailField;
    @Before
    public void open_registration_page()
    {   System.out.println("before each scenario");
        loginPage = new LoginPage(driver);
        //System.out.println(loginPage.getEmailFieldText());
        loginPage.clickNewUserBtn();

    }
    @After(value = " not @successful_registration")
    public void go_back(){
        System.out.println("after each scenario");
        driver.navigate().back();
    }
    @Given("User is on the registration page")
    public void userClicksOnTheNewUserButton() throws MalformedURLException {
        assertTrue(registrationPage.isOnPage());
    }

    @When("User enters {string}, {string}, {string}, and {string}")
    public void userEnters(String firstName, String lastName, String email, String password) {
        emailField = email;
        registrationPage.setLastName(lastName);
        registrationPage.setFirstName(firstName);
        registrationPage.setEmail(email);
        registrationPage.setPassword(password);
        registrationPage.setConfirmPassword(password);
    }

    @And("User accepts the terms and conditions")
    public void userAcceptsTheTermsAndConditions() {
        registrationPage.acceptConditions();
        loginPage.waitForPageLoad(driver);
    }
    @Then("User should be registered successfully")
    public void userShouldBeRegisteredSuccessfully() {
        driver.hideKeyboard();
        //assertTrue(loginPage.isOnPage());
        String expected = emailField;

        String actual =loginPage.getEmailFieldText();
        System.out.println(expected);
        System.out.println(actual);
        assertTrue(expected.equals(actual),"does not match");
        //assertTrue(loginPage.isOnPage());
    }
    @And("User clicks on the register button")
    public void userClicksOnTheRegisterButton() {
        registrationPage.clickRegisterButton();
    }
    @Then("User should see an error message indicating that the password must be valid")
    public void userShouldSeeAnErrorMessageIndicatingThatThePasswordMustBeValid() {
        String actual =registrationPage.get_passwd_error_message();
        String expected1="Must contain 1 letter lowercase and uppercase, 1 number, 1 special char and 8 chars long";
        String expected2="le message en fr" ;
        System.out.println(actual);
        assertTrue(actual.equals(expected1) || actual.equals(expected2),"does not match ");}
    @Then("User should see an error message indicating that the email is invalid")
    public void userShouldSeeAnErrorMessageIndicatingThatTheEmailIsInvalid() {
        String actual =registrationPage.get_email_error_message();
        String expected1="The email is invalid";
        String expected2="le message en fr" ;
        System.out.println(actual);
        assertTrue(actual.equals(expected1) || actual.equals(expected2),"does not match ");
    }
    @And("User does not accept the terms and conditions")
    public void userDoesNotAcceptTheTermsAndConditions() {
        assertFalse(registrationPage.check_accept_conditions());
    }
    @Then("User should  not be able to sign Up")
    public void userShouldShouldNotBeAbleToSignUp() {
        System.out.println(registrationPage.register_btn_is_enabled());
        assertTrue(registrationPage.register_btn_is_enabled());
    }


    @Then("User should see an error message indicating that the email already exists")
    public void userShouldSeeAnErrorMessageIndicatingThatTheEmailAlreadyExists() {
        assertTrue(registrationPage.isOnPage());
    }

    @Override
    public
    void onStart ( ITestContext context ) {

    }
}