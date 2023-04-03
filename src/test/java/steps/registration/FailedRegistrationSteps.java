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
  /*  @When ("User enters {string}, {string}, {string}, and {string} with an existing email address")
    public
    void userEntersAnExistingEmailAddress ( String firstName , String lastName , String invalidEmail , String password ) {
        registrationPage.setLastName ( lastName );
        registrationPage.setFirstName ( firstName );
        registrationPage.setEmail ( invalidEmail );
        registrationPage.setPassword ( password );
        registrationPage.setConfirmPassword ( password );

    }
    @And ("User accepts the terms and conditions  For Failed Registration")
    public
    void userAcceptsTheTermsAndConditionsForFailedRegistration ( ) {
        registrationPage.acceptConditions ( );
        throw new io.cucumber.java.PendingException();
    }

    @And ("User clicks on the register button For Failed Registration")
    public
    void userClicksOnTheRegisterButtonForFailedRegistration ( ) {

        loginPage = registrationPage.clickRegisterButton ( );
        throw new io.cucumber.java.PendingException();
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

*/




    @When ("User enters FirstName, LastName, Email, and passwordLength")
    public
    void userEntersAPasswordWithLessThanCharacters () {
      String  firstName="oumaima";
        String  lastName="kalboussi";
        String  email="kalboussioumaima1@gmail.com";
       int  passwordLength=8;


        // Enter a password with length less than 'passwordLength'
        String password = "1234"; // example password
        if (password.length() >= passwordLength) {
            password = password.substring(0, passwordLength - 1);
            registrationPage.setLastName ( lastName );
            registrationPage.setFirstName ( firstName );
            registrationPage.setEmail ( email );
            registrationPage.setPassword ( password );
            registrationPage.setConfirmPassword ( password );
            registrationPage.acceptConditions ( );
            loginPage = registrationPage.clickRegisterButton ( );
            throw new io.cucumber.java.PendingException();



        }
    }

    @Then ("User should see an error message indicating that the password is too short")
    public
    void userShouldSeeAnErrorMessageIndicatingThatThePasswordIsTooShort ( ) {
        driver.hideKeyboard ( );
        assertTrue ( registrationPage.isOnPage ( ) );


    }

    /*@When ("User enters a password without a special character")
    public
    void userEntersAPasswordWithoutASpecialCharacter ( ) {
    }

    @Then ("User should see an error message indicating that the password must contain at least one special character")
    public
    void userShouldSeeAnErrorMessageIndicatingThatThePasswordMustContainAtLeastOneSpecialCharacter ( ) {
    }*/
}


