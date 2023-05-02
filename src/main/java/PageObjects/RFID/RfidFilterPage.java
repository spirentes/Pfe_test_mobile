package PageObjects.RFID;

import PageObjects.BasePage;
import PageObjects.sites.SitesListPage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public
class RfidFilterPage extends BasePage {

    private AndroidDriver driver;

//    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uF110\")")
//    private  WebElement resetIcon;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uF455\")")
    private  WebElement userIcon;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uF500\")")
    private  WebElement selectIcon;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Apply\")")
    private WebElement    applyBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Clear\")")
    private WebElement    clearBtn;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uF110\")")
    private WebElement exitBtn;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Filters\")")
    private WebElement pageName;
    List<WebElement> UserNames ;
    WebElement         UserName ;
    public boolean isUserDisplayed(String userNameTxt) {

        try {
            UserName = driver.findElement (
                    MobileBy.androidUIAutomator (
                            "new UiSelector().className(\"android.widget.TextView\").text(\"" + userNameTxt + "\")" ) );
            UserNames.add ( UserName );
            return true;
        } catch ( NoSuchElementException e ) {
            System.out.println ( "rfid not found " );
            return false;}}
    public
    RfidFilterPage ( AndroidDriver driver ) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator ( driver), this );
    }
    public
    RFIDCardsListPage clickApply ( ) {
        click (applyBtn );
        return new RFIDCardsListPage( driver );
    }
public SelectUsersPage selectUsers(){
        click ( selectIcon );
        return new SelectUsersPage ( driver );
}
    public
    void clickClear ( ) {
        click ( clearBtn);
    }
    public
    RFIDCardsListPage clickExit ( ) {
        click (exitBtn  );
        return new RFIDCardsListPage ( driver );
    }
    public boolean isOnPage() {
        try {

            return pageName.isDisplayed();
        } catch ( NoSuchElementException e) {

            return false;
        }
    }




}

