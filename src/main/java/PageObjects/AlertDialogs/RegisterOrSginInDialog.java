package PageObjects.AlertDialogs;

import PageObjects.base.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;



public class RegisterOrSginInDialog extends BasePage {

 AndroidDriver driver ;
//    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[@index='1']")
//    WebElement AlertTitle ;
    @AndroidFindBy(uiAutomator ="new UiSelector().className(\"android.widget.TextView\").text(\"What would you like to do?\")")
WebElement AlertTitle ;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[2]")
    WebElement errorMessage ;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.widget.Button")
    WebElement SignUpBtn ;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]/android.widget.Button")
    WebElement SignInBtn ;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[4]/android.widget.Button")
    WebElement closeBtn ;

    public RegisterOrSginInDialog(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator( driver), this );
    }
    public
    void click_signIn_button ( ) {
        click (SignInBtn );
    }
    public
    void click_signUp_button ( ) {
        click (SignUpBtn);
    }
    public
    void click_close_button ( ) {
        click (closeBtn);
    }
    public
    String get_alert_title ( ) {
        return getAttribute(AlertTitle,"text");
    }
    public
    String get_error_message ( ) {
        return getAttribute(errorMessage,"text");
    }












}
