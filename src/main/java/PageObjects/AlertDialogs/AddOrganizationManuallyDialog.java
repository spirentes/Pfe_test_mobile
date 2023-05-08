package PageObjects.AlertDialogs;

import PageObjects.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AddOrganizationManuallyDialog  extends BasePage {
    AndroidDriver driver ;
    @AndroidFindBy(uiAutomator =" new UiSelector().className(\"android.widget.TextView\").text(\"\uE729\")")
    WebElement addOrgLog ;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.widget.EditText")
   WebElement subDomainField ;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.widget.EditText")
    WebElement nameField ;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.widget.Button")
    WebElement createButton;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]/android.widget.Button")
    WebElement backButton ;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")
    WebElement exitButton ;

    public AddOrganizationManuallyDialog( AndroidDriver driver ) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator( driver), this );
    }
    public void setSubDomainField ( String subDomain ) {
        sendText (subDomainField,subDomain);
    }

    public
    void setNameField ( String name ) {
        sendText (nameField, name );
    }

    public
    void click_create_button ( ) {
        click (createButton );
    }
    public
    void click_back_button ( ) {
        click (backButton );
    }
    public
    void click_exit_button ( ) {
        click (exitButton );
    }

    public boolean isOnPage() {
        try {
            // Check for the presence of the alertTitle element
            return addOrgLog.isDisplayed();
        } catch (NoSuchElementException e) {
            // The element is not present, so the alert is not displayed
            return false;
        }
    }
}
