package PageObjects.RFID;

import PageObjects.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public
class RFIDCardsListPage extends BasePage {
    private        AndroidDriver driver;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uDB80\uDE33\")")
    private WebElement btnOpenFilterPage;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").text(\"Search\")")
    private WebElement txtSearchField;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uDB80\uDD59\")")
    private WebElement btnClearSearchField;

    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"RFID Cards\")")
    private  WebElement    pageTitle;
    @AndroidFindBy (xpath= "//android.view.ViewGroup[1]/android.widget.TextView[@index='0'][@bounds='[13,93][75,162]']")

    WebElement backBtn  ;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uDB80\uDE32\")")
    public WebElement btnOpenNonemptyFilterPage;
    List<WebElement> RFIDNames ;
    WebElement       RFIDName ;
    public
    RfidFilterPage openNonEmptyFilterPage ( ) {
        click ( btnOpenNonemptyFilterPage);
        return new RfidFilterPage ( driver );

    }


    public RFIDCardsListPage( AndroidDriver driver ) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator ( driver), this );
    }
    public void clickBackBtn()
    {click ( backBtn );}
    public
    boolean isOnPage ( ) {
        try {

            return pageTitle.isDisplayed();
        } catch ( NoSuchElementException e) {

            return false;
        }
    }
    public
    void searchForRFIDcard( String nameRfid) {
        clear ( txtSearchField );
        sendText ( txtSearchField , nameRfid );
    }
    public void setBtnClearSearchField()
    {
        click ( btnClearSearchField );
    }

    public
    RfidFilterPage openFilterPage ( ) {
        click ( btnOpenFilterPage);
        return new RfidFilterPage ( driver );

    }
    public boolean isSiteDisplayed(String RFIDNameTxt) {

        try {
            RFIDName = driver.findElement (
                    MobileBy.androidUIAutomator (
                            "new UiSelector().className(\"android.widget.TextView\").text(\"" + RFIDNameTxt + "\")" ) );
            RFIDNames.add ( RFIDName );
            return true;
        } catch ( NoSuchElementException e ) {
            System.out.println ( "Site not found " );
            return false;
        }


    }}