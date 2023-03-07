package registration;

import base.BaseTests;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegistrationPage;

import java.net.MalformedURLException;

import static org.testng.AssertJUnit.assertEquals;

public
class RegistrationTests extends BaseTests {

    RegistrationPage registrationPage;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        configureAppium();
        registrationPage = new RegistrationPage(driver);
    }

    @Test
    public void testSuccessfulRegistration() {
        registrationPage.setFirstName("John");
        registrationPage.setLastName("Doe");
        registrationPage.setEmail("johndoe@example.com");
        registrationPage.setPassword("password123");
        registrationPage.acceptConditions ();
        LoginPage loginPage = registrationPage.clickRegisterButton ( );

        // Add assertions for successful registration
        assertEquals(loginPage, "Login Page");
        // ...
    }

    @Test
    public void testRegistrationWithoutAgreeingTerms() {
        registrationPage.setFirstName("John");
        registrationPage.setLastName("Doe");
        registrationPage.setEmail("johndoe@example.com");
        registrationPage.setPassword("password123");
        LoginPage loginPage = registrationPage.clickRegisterButton();

        // Add assertions for registration without agreeing to term
        assertEquals(driver.findElement ( By.xpath ( "//android.widget.TextView[@index='9']" ) ).getText ( ),
                     "Vous devez accepter les conditions d'utilisation");
        // ...
    }

    @Test
    public void testRegistrationWithExistingEmail() {
        registrationPage.setFirstName("John");
        registrationPage.setLastName("Doe");
        registrationPage.setEmail("johndoe@example.com");
        registrationPage.setPassword("password123");
        registrationPage.acceptConditions ();
        LoginPage loginPage = registrationPage.clickRegisterButton();

        // Add assertions for registration with existing email
        assertEquals(driver.findElement(By.xpath("")).getText(), "Email already exists");
        // ...
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        service.stop();
    }
}

