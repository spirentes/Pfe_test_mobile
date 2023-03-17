package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public
class LoginPage extends BasePage{
    private AndroidDriver driver;
   // private By            newUser           =By.xpath ( "//android.view.ViewGroup[@index='3']/android.widget.TextView" );
    private By            emailField        =
            By.xpath ( "//android.view.ViewGroup[@index='5']/android.widget.EditText" );
    private By            passwordField     =
            By.xpath ( "//android.view.ViewGroup[@index='6']/android.widget.EditText" );
    private By            loginButton       =
            By.xpath ( "//android.view.ViewGroup[@index='9']/android.widget.TextView" );
    private By            conditionCheckbox = By.xpath (
            "//android.view.ViewGroup[@index='8']/android.view.ViewGroup[@index='0']/android.widget.TextView" );
    @AndroidFindBy(xpath= "//android.view.ViewGroup[@index='3']/android.widget.TextView")
    WebElement newUser   ;


    public
    LoginPage ( AndroidDriver driver ) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator ( driver), this );
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
         click (newUser );
        return new RegistrationPage ( driver );
    }
}
