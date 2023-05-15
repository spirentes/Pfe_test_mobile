package PageObjects.login;

import PageObjects.base.BasePage;
import PageObjects.charging_stations.SearchChargingStationsMapPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public
class LoginPage extends BasePage {
    private AndroidDriver driver;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]")
    WebElement organizationButton;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]")
    WebElement organizationButton2;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='5']/android.widget.EditText")
    WebElement emailField;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='6']/android.widget.EditText")
    WebElement passwordField;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Login\")")
    WebElement loginButton;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='8']/android.view.ViewGroup[@index='0']/android.widget.TextView")
    WebElement conditionCheckbox;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"New User?\")")
    WebElement newUser   ;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"WattzHub CPO\")")
    WebElement pageTitle;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"You must accept the End-User License Agreement\")")
    WebElement terms_error_message;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"The email is invalid\")")
    WebElement emailErrorMessage;
    //can not locate toast!!!!!!!!!!!!!!!!!!!
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\")")
   WebElement passwdErrorMessage;
    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.ImageView")
    WebElement companyImage;

    public
    LoginPage ( AndroidDriver driver ) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator ( driver), this );
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

    public SearchChargingStationsMapPage clickLoginButton ( ) {
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
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOf(loginButton));
            return loginButton.isDisplayed();
        } catch (NoSuchElementException e) {

            return false;
        }
    }
    public void clickOragnizationButton() {
        try {
            if(companyImage.isDisplayed())
            {
                click(organizationButton);

            }

        }
        catch (NoSuchElementException e)
        {
            click(organizationButton2);
        }

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
    public boolean check_accept_conditions(){return conditionCheckbox.isSelected();}
    public String get_email_error_message ( ) {
        return getAttribute(emailErrorMessage,"text");
    }
        public String get_passwd_error_message ( ) {
       return getAttribute(passwdErrorMessage,"text");
   }
    public String get_terms_error_message ( ) {
        return getAttribute(terms_error_message,"text");
    }
}