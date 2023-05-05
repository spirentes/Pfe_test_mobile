package PageObjects.RFID;

import PageObjects.base.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public
class SelectUsersPage extends BasePage {
    AndroidDriver driver;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.EditText\").text(\"Search\")")
    private WebElement txtSearchField;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uDB80\uDD59\")")
    private WebElement btnvalidateSearchField;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Select Users\")")
    private  WebElement    pageTitle;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uF110\")")
    private WebElement exitBtn;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Reset\")")
    private WebElement    resetBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Validate\")")
    private WebElement    validateBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uDB80\uDD59\")")
    private WebElement btnClearSearchField;
    List<WebElement> RFIDNames ;
    WebElement        RFIDName ;
    public boolean isRFIDDisplayed(String RFIDNameTxt) {

        try {
            RFIDName = driver.findElement (
                    MobileBy.androidUIAutomator (
                            "new UiSelector().className(\"android.widget.TextView\").text(\"" + RFIDNameTxt + "\")" ) );
            RFIDNames.add ( RFIDName );
            return true;
        } catch ( NoSuchElementException e ) {
            System.out.println ( "rfid not found " );
            return false;
        }


    }
    public void setBtnClearSearchField()
    {
        click ( btnClearSearchField );
    }
    public
    void searchForUser( String nameUser) {
        clear ( txtSearchField );
        sendText ( txtSearchField , nameUser );
    }
    public
    SelectUsersPage ( AndroidDriver driver ) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator ( driver), this );
    }
    public
    SelectUsersPage clickReset ( ) {
        click (resetBtn );
        return new SelectUsersPage ( driver );
    }

    public
    void clickValidate ( ) {
        click ( validateBtn);
    }
    public
    RfidFilterPage clickExit ( ) {
        click (exitBtn  );
        return new RfidFilterPage ( driver );
    }
    public boolean isOnPage() {
        try {

            return pageTitle.isDisplayed();
        } catch ( NoSuchElementException e) {

            return false;


        }}

    public void selectUser(String userName) {
        By userSelector = MobileBy.AndroidUIAutomator ( "new UiSelector().text(\"" + userName + "\")" );
        driver.findElement(userSelector).click();
    }






}
