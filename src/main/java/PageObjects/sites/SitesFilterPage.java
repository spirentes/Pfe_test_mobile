package PageObjects.sites;

import PageObjects.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public
class SitesFilterPage extends BasePage {
    private AndroidDriver driver;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Apply\")")
    private WebElement    applyBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Clear\")")
    private WebElement    clearBtn;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uF110\")")
    private WebElement exitBtn;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.Switch\").index(3)")
    private WebElement roamingSitesBtn;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Filters\")")
    private WebElement pageName;
    public
    SitesFilterPage ( AndroidDriver driver ) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator ( driver), this );
    }
    public void selectRoamingSites(){
        click ( roamingSitesBtn );
    }
    public
    SitesListPage clickApply ( ) {
        click (applyBtn );
        return new SitesListPage ( driver );
    }

    public
    void clickClear ( ) {
        click ( clearBtn);
    }
    public
    SitesListPage clickExit ( ) {
        click (exitBtn  );
        return new SitesListPage ( driver );
    }
    public boolean isOnPage() {
        try {

            return pageName.isDisplayed();
        } catch ( NoSuchElementException e) {

            return false;
        }
    }
    public boolean isRoamingSitesEnabled(){
        return is_Enabled ( roamingSitesBtn );
    }



}

