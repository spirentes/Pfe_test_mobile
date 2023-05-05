package PageObjects.users;

import PageObjects.base.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public
class UsersListPage  extends BasePage {
    private        AndroidDriver driver;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Users\")")
    private WebElement pageTitle;

    @AndroidFindBy(xpath= "//android.view.ViewGroup[1]/android.widget.TextView[@index='0'][@bounds='[13,93][75,162]']")
    private WebElement btnBackToPreviousScreen;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uDB80\uDE33\")")
    private WebElement btnOpenFilterPage;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").text(\"Search\")")
    private WebElement txtSearchField;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"No users\")")
    private WebElement noUsersMsg;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uDB80\uDD59\")")
    private WebElement btnClearSearchField;

List<WebElement> userNames ;
WebElement userName ;



    public UsersListPage ( AndroidDriver driver ) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator ( driver), this );
    }
    public void clickBackBtn()
    {click ( btnBackToPreviousScreen );}
    public
    void searchForUser( String nameUser ) {
        clear ( txtSearchField );
        sendText ( txtSearchField , nameUser );
    }

    public
    UsersFilterPage openFilterPage ( ) {
        click ( btnOpenFilterPage);
        return new UsersFilterPage ( driver );

    }
public boolean noUsersMsgIsDisplayed(){
        return noUsersMsg.isDisplayed ();
}
    public
    boolean isOnPage ( ) {
        try {

            return pageTitle.isDisplayed();
        } catch ( NoSuchElementException e) {

            return false;
        }
    }
    public boolean isUserDisplayed(String userNameTxt) {

        try {
            userName = driver.findElement (
                    MobileBy.androidUIAutomator (
                            "new UiSelector().className(\"android.widget.TextView\").text(\"" + userNameTxt + "\")" ) );
            userNames.add ( userName );
            return true;
        } catch ( NoSuchElementException e ) {
            System.out.println ( "User not found " );
            return false;
        }
    }}