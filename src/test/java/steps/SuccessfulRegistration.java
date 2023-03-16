package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.base.BaseTests;

public
class SuccessfulRegistration extends BaseTests {
    @Given( "I am on the registration page")
    public
    void iAmOnTheRegistrationPage ( ) {
    }

    @When( "I enter {string} as the first name")
    public
    void iEnterAsTheFirstName ( String arg0 ) {
    }

    @And( "I enter {string} as the last name")
    public
    void iEnterAsTheLastName ( String arg0 ) {
    }

    @And( "I enter {string} as the email")
    public
    void iEnterAsTheEmail ( String arg0 ) {
    }

    @And( "I enter {string} as the password")
    public
    void iEnterAsThePassword ( String arg0 ) {
    }

    @And( "I accept the terms and conditions")
    public
    void iAcceptTheTermsAndConditions ( ) {
    }

    @And( "I click on the register button")
    public
    void iClickOnTheRegisterButton ( ) {
    }

    @Then( "I should see the login page")
    public
    void iShouldSeeTheLoginPage ( ) {
    }
}
