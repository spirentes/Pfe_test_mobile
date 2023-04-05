package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


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
//    @AndroidFindBy(uiAutomator ="" )
//    private WebElement forgetPassword;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='8']/android.view.ViewGroup[@index='0']/android.widget.TextView")
    WebElement conditionCheckbox;
    @AndroidFindBy(xpath= "//android.view.ViewGroup[@index='3']/android.widget.TextView")
    WebElement newUser   ;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"WattzHub CPO\")")
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
    void clickNewUserBtn ( ) {
         click (newUser );
        //return new RegistrationPage ( driver );
    }
    public boolean isOnPage() {
        try {
            // Check for the presence of the alertTitle element
            return pageTitle.isDisplayed();
        } catch (NoSuchElementException e) {
            // The element is not present, so the alert is not displayed
            return false;
        }
    }
    public void clickOragnizationButton() {
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        organizationButton = wait.until(ExpectedConditions.elementToBeClickable(organizationButton));
        click(organizationButton);
    }
    public String getEmailFieldText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(newUser));
       return getAttribute(emailField,"Text");
    }
    public void waitForPageLoad(AndroidDriver driver ) {
        System.out.println("waiting for login page to load.....");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(loginButton));
    }
}
