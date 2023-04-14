package PageObjects.users;

import PageObjects.BasePage;
import PageObjects.SearchChargingStationsMapPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public
class UsersFilterPage extends BasePage {
    private AndroidDriver driver;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Apply\")")
    private WebElement    applyBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Clear\")")
    private WebElement    clearBtn;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uF110\")")
    private WebElement exitBtn;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.Switch\").index(3)")
    private WebElement roamingUsersBtn;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Filters\")")
    private WebElement pageName;
    public
    UsersFilterPage ( AndroidDriver driver ) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator ( driver), this );
    }
    public void selectRoamingUsers(){
        click ( roamingUsersBtn );
    }
    public
    UsersListPage clickApply ( ) {
        click (applyBtn );
        return new UsersListPage ( driver );
    }

    public
    void clickClear ( ) {
        click ( clearBtn);
    }
    public
    UsersListPage clickExit ( ) {
        click (exitBtn  );
        return new UsersListPage ( driver );
    }
    public boolean isOnPage() {
        try {

            return pageName.isDisplayed();
        } catch ( NoSuchElementException e) {

            return false;
        }
    }
    public boolean isRoamingUsersEnabled(){
        return is_Enabled ( roamingUsersBtn );
    }



}

