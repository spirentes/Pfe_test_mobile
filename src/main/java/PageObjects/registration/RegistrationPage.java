package PageObjects.registration;

import PageObjects.base.BasePage;
import PageObjects.login.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.PageFactory.initElements;

public
class RegistrationPage extends BasePage {
    private  AndroidDriver driver;
    @AndroidFindBy(xpath= "//android.view.ViewGroup[@index='6']/android.widget.EditText[@bounds='[108,685][663,765]']")
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
//    @AndroidFindBy(uiAutomator = "new UiSelector.className(\"android.widget.TextView\").text(\"Must contain 1 letter lowercase and uppercase, 1 number, 1 special char and 8 chars long\")")
//    WebElement passwdErrorMessage;
    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.TextView[5]")
    WebElement passwdErrorMessage;
    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.TextView[5]")
    WebElement emailErrorMessage;
    //can not locate the toast
    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.TextView[5]")
    WebElement emailAlreadyExist;
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


    public LoginPage clickRegisterButton ( ) {
        click (registerButton);
        return new LoginPage ( driver );
    }

    public LoginPage clickBackToLoginButton() {
        click (backToLogin);
        return new LoginPage ( driver );
    }
    public boolean isOnPage() {
        try {
            // Check for the presence of the alertTitle element
            return registerButton.isDisplayed();
        } catch (NoSuchElementException e) {
            // The element is not present, so the alert is not displayed
            return false;
        }
    }
     public String get_passwd_error_message ( ) {
        return getAttribute(passwdErrorMessage,"text");
    }
    public String get_email_error_message ( ) {
        return getAttribute(emailErrorMessage,"text");
    }
     public boolean register_btn_is_enabled(){return registerButton.isEnabled();}
    public boolean check_accept_conditions(){return conditionCheckbox.isSelected();}


}

