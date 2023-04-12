package PageObjects.charging_stations;

import PageObjects.BasePage;
import PageObjects.OCPPConfigPage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public
class ActionsChargingStationsPage extends BasePage {
    private AndroidDriver driver;

     private WebElement    CsName;
    @AndroidFindBy (xpath = "//android.widget.TextView[@text='Reboot']/..")
    private WebElement    rebootBtn;
    @AndroidFindBy (xpath = "//android.widget.TextView[@text='Unlock Connector A']/..")
    private WebElement    unlockConnectorAbtn;
    @AndroidFindBy (xpath = "//android.widget.TextView[@text='Unlock Connector B']/..")
    private WebElement    unlockConnectorBbtn;
    @AndroidFindBy (xpath = "//android.widget.TextView[@text='Reset']/..")
    private WebElement    resetBtn;
    @AndroidFindBy (xpath = "//android.widget.TextView[@text='Clear Cache']/..")
    private WebElement    clearCacheBtn;


    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uE241\")")
    private WebElement    moveToOCPP;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uE88E\")")
    private WebElement   moveToProperties;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Request Configuration\")")
    private WebElement   requestConfig;


    public
    ActionsChargingStationsPage ( AndroidDriver driver ) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator ( driver), this );
    }
    public boolean isOnPage(String Csname) {
        try {
            CsName=driver.findElement(MobileBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\""+Csname+"\")"));
            return CsName.isDisplayed();
        } catch (NoSuchElementException e) {
            // The element is not present, so the page is not displayed
            return false;
        }
    }

    public void clickRebootButton() {
        click(rebootBtn);
    }

    public void clickUnlockConnectorAButton() {
        click(unlockConnectorAbtn);
    }

    public void clickResetButton() {
        click(resetBtn);
    }

    public void clickClearCacheButton() {
        click(clearCacheBtn);
    }
    public void clickOcppButton() {
        click(moveToOCPP);
    }

    public void clickMoveToOCPP() {
        click(moveToOCPP);
    }

    public void clickMoveToProperties() {
        click( moveToProperties);
    }
public boolean areActionsEnabled(){
     List<WebElement> actionBtns= new ArrayList<>();
     actionBtns.add(rebootBtn);
//     actionBtns.add(unlockConnectorAbtn);
//     actionBtns.add(unlockConnectorBbtn);
     actionBtns.add(resetBtn);
     actionBtns.add(clearCacheBtn);
    WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds ( 20 ));
    wait.until(ExpectedConditions.visibilityOf(rebootBtn));
     for(WebElement element :actionBtns)
     {
         if (element.getAttribute("clickable").equals("true"))
         {
             return true ;
         }
     }
     return false;
}
public Boolean ocpp_param_are_displayed()
{
    return requestConfig.isDisplayed();
}
}
