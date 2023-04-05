package PageObjects.AlertDialogs;

import PageObjects.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public
class NoOrganizationFound extends BasePage {
    private AndroidDriver driver ;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.widget.TextView[@index='1']")
    WebElement alertTitle;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.widget.Button/android.widget.TextView[@index='0']")
    WebElement yesButton;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]/android.widget.Button/android.widget.TextView[@index='0']")
    WebElement cancelButton;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.widget.TextView[@index='0']")
    WebElement exitBtn ;
    public
    NoOrganizationFound ( AndroidDriver driver ) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator ( driver), this );
    }
    public void clickExitButton()
    {
        click(exitBtn);
    }
    public boolean isOnPage() {
        try {
            // Check for the presence of the alertTitle element
            return alertTitle.isDisplayed();
        } catch (NoSuchElementException e) {
            // The element is not present, so the alert is not displayed
            return false;
        }
    }
    public void clickYes ()
    {
        click(yesButton);
    }
    public void clickCancel ()
    {
        click(cancelButton);
    }
    public void reset() {
        driver.closeApp();
        driver.launchApp();
    }
}
