package PageObjects.AlertDialogs;

import PageObjects.base.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public
class NoOrganizationFound extends BasePage {
    private AndroidDriver driver ;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"NO ORGANIZATION FOUND5\")")
    WebElement alertTitle;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"YES\")")
    WebElement yesButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"CANCEL\")")
    WebElement cancelButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uF110\")")
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