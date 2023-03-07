package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;


public
class LoginPage {
    private AndroidDriver driver;
    private By            newUser           =
            By.xpath ( "//android.view.ViewGroup[@index='3']/android.widget.TextView" );
    private By            emailField        =
            By.xpath ( "//android.view.ViewGroup[@index='5']/android.widget.EditText" );
    private By            passwordField     =
            By.xpath ( "//android.view.ViewGroup[@index='6']/android.widget.EditText" );
    private By            loginButton       =
            By.xpath ( "//android.view.ViewGroup[@index='9']/android.widget.TextView" );
    private By            conditionCheckbox = By.xpath (
            "//android.view.ViewGroup[@index='8']/android.view.ViewGroup[@index='0']/android.widget.TextView" );

    public
    LoginPage ( AndroidDriver driver ) {
        this.driver = driver;
    }

    public
    void setEmail ( String email ) {
        driver.findElement ( emailField ).sendKeys ( email );
    }

    public
    void setPassword ( String password ) {
        driver.findElement ( passwordField ).sendKeys ( password );
    }

    public
    void acceptConditions ( ) {
        driver.findElement ( conditionCheckbox ).click ( );
    }

    public
    SearchChargingStationsMapPage clickLoginButton ( ) {
        driver.findElement ( loginButton ).click ( );
        return new SearchChargingStationsMapPage ( driver );
    }

    public
    RegistrationPage clickNewUserBtn ( ) {
        driver.findElement ( newUser ).click ( );
        return new RegistrationPage ( driver );
    }
}
