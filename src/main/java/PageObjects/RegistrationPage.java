package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public
class RegistrationPage extends BasePage {
    private  AndroidDriver driver;
    @AndroidFindBy(xpath= "(//android.widget.Toast)[1]")
    WebElement mailExistToast ;
    @AndroidFindBy(xpath= "//android.view.ViewGroup[@index='6']/android.widget.EditText[@bounds='[108,713][663,793]']")
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
        WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds ( 60 ));
        firstnameField = wait.until ( ExpectedConditions.visibilityOf ( firstnameField ) );
        clear(firstnameField );
        sendText(firstnameField , firstname);
    }
    public void setLastName(String name) {
        WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds ( 60 ));
        nameField = wait.until ( ExpectedConditions.visibilityOf ( nameField ) );
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
    LoginPage clickRegisterButton ( ) {
       click (registerButton);
        return new LoginPage ( driver );
    }

    public LoginPage clickLoginButton() {
        click (backToLogin);
        return new LoginPage ( driver );
    }
   /* public void waitForToast ( WebDriver driver ) {
        boolean toastPresent = false;
        int count = 0;
        while (!toastPresent && count < 10) {
            try {

                WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds ( 60 ));
                mailExistToast = wait.until ( ExpectedConditions.visibilityOf (  mailExistToast ) );
                toastPresent = true;
            } catch ( StaleElementReferenceException e) {
                // do nothing, continue loop
            }
            count++;
        }
    }
    public String getEmailToastText(){
        waitForToast (  this.driver) ;

        return getAttribute(mailExistToast,"Text");
    }*/

    public boolean isOnPage() {
        try {
            // Check for the presence of the alertTitle element
            return registerButton.isDisplayed();
        } catch ( NoSuchElementException e) {
            // The element is not present, so the alert is not displayed
            return false;
        }
    }




}

