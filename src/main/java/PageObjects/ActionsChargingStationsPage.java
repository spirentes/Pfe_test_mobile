package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public
class ActionsChargingStationsPage extends BasePage {
    private AndroidDriver driver;
    @AndroidFindBy (xpath = "")
    private WebElement    pageName;
    @AndroidFindBy (xpath = "")
    private WebElement    rebootBtn;
    @AndroidFindBy (xpath = "")
    private WebElement    unlockConnectorABtn;
    @AndroidFindBy (xpath = "")
    private WebElement    resetBtn;
    @AndroidFindBy (xpath = "")
    private WebElement    clearCacheBtn;
    @AndroidFindBy (xpath = "")
    private WebElement    moveToOCPP;
    @AndroidFindBy (xpath = "")
    private WebElement   moveToProperties;


    public
    ActionsChargingStationsPage ( AndroidDriver driver ) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator ( driver), this );
    }
    public boolean isOnPage() {
        try {
            // Check for the presence of the navMenuIcon element
            return pageName.isDisplayed();
        } catch (NoSuchElementException e) {
            // The element is not present, so the page is not displayed
            return false;
        }
    }
    public void clickRebootButton() {
        click(rebootBtn);
    }

    public void clickUnlockConnectorAButton() {
        click(unlockConnectorABtn);
    }

    public void clickResetButton() {
        click(resetBtn);
    }

    public void clickClearCacheButton() {
        click(clearCacheBtn);
    }

    public OCPPConfigPage clickMoveToOCPP() {
        click(moveToOCPP);
        return new OCPPConfigPage (driver);
    }

    public InfoChargingStationsPage clickMoveToProperties() {
        click( moveToProperties);
        return new InfoChargingStationsPage (driver);
    }


}
