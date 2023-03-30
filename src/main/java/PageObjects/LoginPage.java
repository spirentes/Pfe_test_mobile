package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public
class LoginPage extends BasePage{
    private AndroidDriver driver;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]/android.widget.TextView")
    WebElement organizationButton;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='5']/android.widget.EditText")
    WebElement emailField;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='6']/android.widget.EditText")
    WebElement passwordField;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='9']/android.widget.TextView")
    WebElement loginButton;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='8']/android.view.ViewGroup[@index='0']/android.widget.TextView")
    WebElement conditionCheckbox;
    @AndroidFindBy(xpath= "//android.view.ViewGroup[@index='3']/android.widget.TextView")
    WebElement newUser   ;
    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.TextView[@index='1']")
    WebElement pageTitle;

    public
    LoginPage ( AndroidDriver driver ) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator ( driver), this );
    }
    public void organizationButton ()
    {
        click(organizationButton);
    }
    public
    void setEmail ( String email ) {
        sendText (emailField,email);
    }

    public
    void setPassword ( String password ) {
        sendText (passwordField, password );
    }

    public
    void acceptConditions ( ) {
        click (conditionCheckbox );
    }

    public
    SearchChargingStationsMapPage clickLoginButton ( ) {
        click (loginButton );
        return new SearchChargingStationsMapPage ( driver );
    }


    public
    RegistrationPage clickNewUserBtn ( ) {
        click (newUser );
        return new RegistrationPage ( driver );
    }
    public boolean isOnPage() {
        try {
            // Check for the presence of the alertTitle element
            return loginButton.isDisplayed();
        } catch (NoSuchElementException e) {
            // The element is not present, so the alert is not displayed
            return false;
        }
    }
    public void clickOragnizationButton()
    {
        click(organizationButton);
    }
    public String getEmailFieldText(){
        return getAttribute(emailField,"Text");
    }
}