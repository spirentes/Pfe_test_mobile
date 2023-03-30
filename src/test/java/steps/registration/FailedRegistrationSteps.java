package steps.registration;

import PageObjects.LoginPage;
import PageObjects.RegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.base.BaseTests;

import java.net.MalformedURLException;

import static org.testng.Assert.*;

public
class FailedRegistrationSteps extends BaseTests {
    RegistrationPage registrationPage;
    LoginPage        loginPage;

    @Given ("User is on the registration page")
    public
    void userIsOnTheRegistrationPage ( ) throws MalformedURLException {
        configureAppium ( );
        loginPage        = new LoginPage ( driver );
        registrationPage = new RegistrationPage ( driver );
        registrationPage = loginPage.clickNewUserBtn ( );

    }
    @When ("User enters {string}, {string}, {string}, and {string} with an existing email address")
    public
    void userEntersAnExistingEmailAddress ( String firstName , String lastName , String invalidEmail , String password ) {
        registrationPage.setLastName ( lastName );
        registrationPage.setFirstName ( firstName );
        registrationPage.setEmail ( invalidEmail );
        registrationPage.setPassword ( password );
        registrationPage.setConfirmPassword ( password );

    }
    @And ("User accepts the terms and conditions  For Failed registration")
    public
    void userAcceptsTheTermsAndConditionsForFailedRegistration ( ) {
        registrationPage.acceptConditions ( );
    }

    @And ("User clicks on the register button For Failed registration")
    public
    void userClicksOnTheRegisterButtonForFailedRegistration ( ) {

        loginPage = registrationPage.clickRegisterButton ( );
    }

    @Then ("User should see an error message indicating that the email already exists")
    public
    void userShouldSeeAnErrorMessageIndicatingThatTheEmailAlreadyExists ( ) {
        driver.hideKeyboard ( );
       // String emailToastText = registrationPage.getEmailToastText ( );
       // assertFalse ( loginPage.isOnPage ( ) );
        assertTrue ( registrationPage.isOnPage ( ) );
        //assertEquals ( emailToastText , "Email already exist" );
    }



    @When ("User enters valid details")
    public
    void userEntersValidDetails ( ) {
    }

    @And ("User does not accept the terms and conditions")
    public
    void userDoesNotAcceptTheTermsAndConditions ( ) {
    }

    @Then ("User should see an error message indicating that the terms and conditions must be accepted")
    public
    void userShouldSeeAnErrorMessageIndicatingThatTheTermsAndConditionsMustBeAccepted ( ) {
    }

    @When ("User enters an invalid email address")
    public
    void userEntersAnInvalidEmailAddress ( ) {
    }

    @Then ("User should see an error message indicating that the email address is invalid")
    public
    void userShouldSeeAnErrorMessageIndicatingThatTheEmailAddressIsInvalid ( ) {
    }

    @When ("User enters a password with less than {int} characters")
    public
    void userEntersAPasswordWithLessThanCharacters ( int arg0 ) {
    }

    @Then ("User should see an error message indicating that the password is too short")
    public
    void userShouldSeeAnErrorMessageIndicatingThatThePasswordIsTooShort ( ) {
    }

    @When ("User enters a password without a special character")
    public
    void userEntersAPasswordWithoutASpecialCharacter ( ) {
    }

    @Then ("User should see an error message indicating that the password must contain at least one special character")
    public
    void userShouldSeeAnErrorMessageIndicatingThatThePasswordMustContainAtLeastOneSpecialCharacter ( ) {
    }
}


