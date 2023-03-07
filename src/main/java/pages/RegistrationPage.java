package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public
class RegistrationPage {
    private  AndroidDriver driver;

    private By firstnameField = By.xpath("//android.widget.EditText[@resource-id='register_name_input']");
    private By lastnameField = By.xpath("//android.widget.EditText[@resource-id='register_name_input']");
    private By emailField = By.xpath("//android.widget.EditText[@resource-id='register_email_input']");
    private By passwordField = By.xpath("//android.widget.EditText[@resource-id='register_password_input']");
    private By confirmPasswordField = By.xpath("//android.widget.EditText[@resource-id='register_confirm_password_input']");
    private By registerButton = By.xpath("//android.widget.Button[@text='REGISTER']");
    private By            conditionCheckbox = By.xpath (
            "//android.view.ViewGroup[@index='8']/android.view.ViewGroup[@index='0']/android.widget.TextView" );
    private By            loginButton       =
            By.xpath ( "//android.view.ViewGroup[@index='9']/android.widget.TextView" );


    public RegistrationPage(AndroidDriver driver){
        this.driver =driver;
    }
    public void setFirstName(String name) {
        driver.findElement(firstnameField).sendKeys(name);
    }
    public void setLastName(String name) {
        driver.findElement(lastnameField).sendKeys(name);
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

