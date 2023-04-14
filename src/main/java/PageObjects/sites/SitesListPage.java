package PageObjects.sites;

import PageObjects.BasePage;

import PageObjects.sites.SitesFilterPage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public
class SitesListPage extends BasePage {
    private        AndroidDriver driver;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"No Site found\")")
    private WebElement noSitesMsg;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Sites\")")
    private  WebElement    pageTitle;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uDB80\uDE33\")")
    private WebElement btnOpenFilterPage;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uDB80\uDE32\")")
    public WebElement btnOpenNonemptyFilterPage;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uDB80\uDD59\")")
    private WebElement btnClearSearchField;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Available\")")
    private WebElement AvailableTxt;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Unavailable\")")
    private WebElement UnavailableTxt;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Charging\")")
    private WebElement ChargingTxt;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Not charging\")")
    private WebElement NotchargingTxt;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").text(\"Search\")")
    private WebElement txtSearchField;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uE409\")")
    private WebElement btnOpenSiteArea;
    @AndroidFindBy (xpath= "//android.view.ViewGroup[1]/android.widget.TextView[@index='0'][@bounds='[13,93][75,162]']")
    WebElement backBtn  ;
    List<WebElement> siteNames ;
    WebElement           siteName ;
    public
    SitesListPage ( AndroidDriver driver ) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator ( driver), this );

    }
    public
    void searchForSite( String nameSite ) {
        clear ( txtSearchField );
        sendText ( txtSearchField , nameSite );
    }
public void clickBtnOpenSiteArea(){
        click ( btnOpenSiteArea );
}
    public
    SitesFilterPage openFilterPage ( ) {
        click ( btnOpenFilterPage);
        return new SitesFilterPage ( driver );

    }
    public boolean isNonEmptyFilterDisplayed(){return btnOpenNonemptyFilterPage.isDisplayed ();}
    public
    SitesFilterPage openNonEmptyFilterPage ( ) {
        click ( btnOpenNonemptyFilterPage);
        return new SitesFilterPage ( driver );

    }

    public void setBtnClearSearchField()
    {
        click ( btnClearSearchField );
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
    public boolean SiteInfoIsDisplayed(){
        return (AvailableTxt.isDisplayed () && UnavailableTxt.isDisplayed () && ChargingTxt.isDisplayed () && NotchargingTxt.isDisplayed ());}
    public boolean isSiteDisplayed(String siteNameTxt) {

        try {
            siteName = driver.findElement (
                    MobileBy.androidUIAutomator (
                            "new UiSelector().className(\"android.widget.TextView\").text(\"" + siteNameTxt + "\")" ) );
            siteNames.add ( siteName );
            return true;
        } catch ( NoSuchElementException e ) {
            System.out.println ( "Site not found " );
            return false;
        }
}

    public boolean noSitesMsgIsDisplayed(){
        return noSitesMsg.isDisplayed ();
    }



 }