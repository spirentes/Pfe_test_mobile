package PageObjects.AlertDialogs;

import PageObjects.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public
class AddAnOrganizationDialog extends BasePage {
AndroidDriver driver ;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.widget.TextView[@bounds='[592,424][663,481]']")
    private WebElement existButton;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[1]")
    private WebElement addOrganizationLogo;
    @AndroidFindBy (xpath = "//android.view.ViewGroup[2]/android.widget.Button/android.widget.TextView")
    private WebElement    QrCodeButton;
    @AndroidFindBy (xpath = " //android.view.ViewGroup[3]/android.widget.Button/android.widget.TextView")
    private WebElement    manuallyButton;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"CANCEL\")")
    private WebElement    cancelButton;
    public AddAnOrganizationDialog( AndroidDriver driver ) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator ( driver), this );
    }
    public boolean isOnPage() {
        try {
            // Check for the presence of the alertTitle element
            return addOrganizationLogo.isDisplayed();
        } catch (NoSuchElementException e) {
            // The element is not present, so the alert is not displayed
            return false;
        }
    }
    public void click_QR_code ()
    {
        click(QrCodeButton);
    }
    public void clickManually ()
    {
        click(manuallyButton);
    }
    public void clickCancel ()
    {
        System.out.println ( "click cancel" );
        click(cancelButton);
    }
    public void clickExistBtn ()
    {
        click(existButton);
    }
}
