package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public
class RegistrationPage {
    private  AndroidDriver driver;

    private By firstnameField = By.xpath("//android.view.ViewGroup[@index='6']/android.widget.EditText");
    private By nameField = By.xpath("//android.view.ViewGroup[@index='5']/android.widget.EditText");
    private By emailField = By.xpath("//android.view.ViewGroup[@index='7']/android.widget.EditText");
    private By passwordField = By.xpath("//android.view.ViewGroup[@index='8']/android.widget.EditText");
    private By confirmPasswordField = By.xpath("//android.view.ViewGroup[@index='9']/android.widget.EditText");
    private By registerButton = By.xpath("//android.widget.Button[@text='REGISTER']");
    private By            conditionCheckbox = By.xpath (
            "//android.view.ViewGroup[@index='8']/android.view.ViewGroup[@index='0']/android.widget.TextView" );
    private By            loginButton       =
            By.xpath ( "//android.view.ViewGroup[@index='9']/android.widget.TextView" );
    private By          backToLogin      =
            By.xpath ( "//android.view.ViewGroup[@index='9']/android.widget.TextView" );


    public RegistrationPage(AndroidDriver driver){
        this.driver =driver;
    }
    public void setFirstName(String firstname) {
        driver.findElement(firstnameField).sendKeys(firstname);
    }
    public void setLastName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void setConfirmPassword(String confirmPassword) {
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
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

    public LoginPage clickRegisterButton() {
        driver.findElement(registerButton).click();
        return new LoginPage ( driver );
    }







}

