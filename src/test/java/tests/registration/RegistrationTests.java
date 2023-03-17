package tests.registration;

import Utils.JsonReader;
import tests.base.BaseTests;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import PageObjects.LoginPage;
import PageObjects.RegistrationPage;

import java.io.IOException;
import java.net.MalformedURLException;

import static org.testng.AssertJUnit.assertEquals;

public
class RegistrationTests extends BaseTests {

    RegistrationPage registrationPage;
    LoginPage loginPage ;
    @DataProvider( name = "Registration Data")
    public
    Object[][] passData ( ) throws IOException, org.json.simple.parser.ParseException {
        return JsonReader.getJSONdata
                                 ( System.getProperty ( "user.dir" ) + "/data/TRegistrationData.json"
                                         , "Registration Data" , 4);
    }

    @BeforeClass
    public
    void setUp ( ) throws MalformedURLException {
        configureAppium ( );
        registrationPage = new RegistrationPage ( driver );

    }




    @Test( dataProvider = "Registration Data")
    public
    void testSuccessfulRegistration (String FirstName, String LastName,String Email,String Password) {
        loginPage.clickNewUserBtn ();
        registrationPage.setFirstName ( FirstName );
        registrationPage.setLastName ( LastName );
        registrationPage.setEmail ( Email );
        registrationPage.setPassword ( Password);
        registrationPage.acceptConditions ( );
        loginPage = registrationPage.clickRegisterButton ( );

        // Add assertions for successful registration

        // ...
    }


    @Test
    public
    void testRegistrationWithExistingEmail ( ) {
        registrationPage.setFirstName ( "John" );
        registrationPage.setLastName ( "Doe" );
        registrationPage.setEmail ( "kalboussioumaima12@gmail.com" );
        registrationPage.setPassword ( "Password123*" );
        registrationPage.acceptConditions ( );
        LoginPage loginPage = registrationPage.clickRegisterButton ( );

        // Add assertions for registration with existing email
        assertEquals ( driver.findElement ( By.xpath ( "" ) ).getText ( ) , "Email already exists" );
        // ...
    }

    @AfterClass
    public
    void tearDown ( ) {
        driver.quit ( );
        service.stop ( );
    }
}

