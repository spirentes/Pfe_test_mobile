package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.PageFactory.initElements;

public
class RegistrationPage extends BasePage {
    private  AndroidDriver driver;
    @AndroidFindBy(xpath= "//android.view.ViewGroup[@index='6']/android.widget.EditText")
    WebElement firstnameField ;
    @AndroidFindBy(xpath= "//android.view.ViewGroup[@index='5']/android.widget.EditText")
    WebElement nameField ;
    @AndroidFindBy(xpath= "//android.view.ViewGroup[@index='7']/android.widget.EditText")
    WebElement emailField  ;
    @AndroidFindBy(xpath= "//android.view.ViewGroup[@index='8']/android.widget.EditText")
    WebElement passwordField  ;
    @AndroidFindBy(xpath= "//android.view.ViewGroup[@index='9']/android.widget.EditText")
    WebElement confirmPasswordField  ;
    @AndroidFindBy(xpath= "//android.view.ViewGroup[@index='12']/android.widget.TextView")
    WebElement registerButton ;
    @AndroidFindBy(xpath= "//android.view.ViewGroup[@index='10']/android.widget.TextView")
    WebElement  conditionCheckbox  ;

    @AndroidFindBy(xpath= "//android.view.ViewGroup[@index='9']/android.widget.TextView")
    WebElement backToLogin;
    public RegistrationPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void setFirstName(String firstname) {
        clear(firstnameField );
        sendText(firstnameField , firstname);
    }
    public void setLastName(String name) {
        clear(nameField);
        sendText(nameField , name);
    }

    public void setEmail(String email) {

        clear(emailField);
        sendText(emailField, email);
    }

    public void setPassword(String password) {
         clear(passwordField );
        sendText(passwordField, password);
    }

    public void setConfirmPassword(String confirmPassword) {
        clear(confirmPasswordField );
        sendText(confirmPasswordField , confirmPassword);
    }
    public
    void acceptConditions ( ) {
        click (conditionCheckbox);
    }

    public
    SearchChargingStationsMapPage clickLoginButton ( ) {
       click (backToLogin);
        return new SearchChargingStationsMapPage ( driver );
    }

    public LoginPage clickRegisterButton() {
        click (registerButton);
        return new LoginPage ( driver );
    }







}

