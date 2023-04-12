package PageObjects.charging_stations;

import PageObjects.*;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public
class ChargingStationsListPage extends BasePage {
    private AndroidDriver driver;
    @AndroidFindBy ( uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uF19C\")")
    WebElement navMenuIcon;
//    @AndroidFindBy ( xpath = "")
//    WebElement chargingStation;
//
//    @AndroidFindBy ( xpath = "")
//    WebElement scanChargingStation;
//
    @AndroidFindBy ( xpath = "//android.view.ViewGroup[1]/android.widget.EditText")
    WebElement searchField;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uDB80\uDE33\")")
    WebElement filterIcon;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uDB80\uDD59\")")
    WebElement clearSearchField;
//
//    @AndroidFindBy ( )
//    WebElement actionBtn;

//    @AndroidFindBy ( uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uF21E\")")
//    WebElement heartbeatIcon;

//    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uE429\")")
//    WebElement moreInfo;
    @AndroidFindBy ( uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uDB80\uDF4D\")")
    WebElement mapViewIcon;
    @AndroidFindBy ( uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"HEARTBEAT\")")
     public WebElement heartBeat;
    @AndroidFindBy ( uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"No Charging Station found\")")
    public WebElement noCsFound;
    WebElement CSname;
    List<WebElement> CSnames;

    public
    ChargingStationsListPage ( AndroidDriver driver ) {
        super ( driver );
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator ( driver ) , this );
    }

    public
    void openNavMenu ( ) {
        click ( navMenuIcon );
    }
//
//    public ScanChargingStations openScanCS ( ) {
//        click ( scanChargingStation );
//        return new ScanChargingStations ( driver );
//
//    }
//
    public
    void searchForCS ( String nameCS ) {
        clear ( searchField );
        sendText ( searchField , nameCS );
    }

    public FiltersPage openFilterPage ( ) {
        click ( filterIcon );
        return new FiltersPage ( driver );

    }

    public
    void clearSearchField ( ) {
        click ( clearSearchField );

    }

//    public ActionsChargingStationsPage openActionPage ( ) {
//        click ( actionBtn );
//        return new ActionsChargingStationsPage ( driver );
//    }
//
//    public
//    void StatusCS ( ) {
//        click ( heartbeatIcon );
//    }
//
//    public ChargePointCSPage seeMoreInfo ( )
//    {
//        click ( moreInfo );
//        return new ChargePointCSPage ( driver );
//    }

    public
    SearchChargingStationsMapPage mapView ( )
    {
        click ( mapViewIcon );
        return new SearchChargingStationsMapPage ( driver );
    }
    public boolean isOnPage() {
        try {
            // Check for the presence of the navMenuIcon element
            return mapViewIcon.isDisplayed();
        } catch (NoSuchElementException e) {
            // The element is not present, so the page is not displayed
            return false;
        }
    }
    public boolean heartBeatIsOnPage() {
        try {
            // Check for the presence of the navMenuIcon element
            return heartBeat.isDisplayed();
        } catch (NoSuchElementException e) {
            // The element is not present, so the page is not displayed
            return false;
        }
    }
//    public boolean isCSDisplayed()
//    {
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            CSname1 = wait.until(ExpectedConditions.visibilityOf(CSname1));
//            // do something with the element
//            return true;
//
//        } catch (TimeoutException e) {
//            System.out.println("Element not found.");
//            return false;
//        }
//    }

    public boolean isCSDisplayed(String CsName) {

        try {
            CSname =driver.findElement(MobileBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\""+CsName+"\")"));
            CSnames.add(CSname);
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("charging station not found ");
            return false;
        }
    }
    public void clcikMoreInfoButton(String CsName)
    {

        String xpath ="//android.widget.TextView[@text='"+CsName+"']";
        System.out.println(xpath);
        WebElement parent_element= driver.findElement(By.xpath(xpath+"/.."));
        WebElement moreInfoBtn =parent_element.findElement(By.xpath("//android.widget.TextView[@text='\uE429']"));
        click(moreInfoBtn);


    }
    public void clickHeartbeatBtn(String CsName)
    {

        String xpath ="//android.widget.TextView[@text='"+CsName+"']";
        System.out.println(xpath);
        WebElement parent_element= driver.findElement(By.xpath(xpath+"/.."));
        WebElement moreInfoBtn =parent_element.findElement(By.xpath("//android.widget.TextView[@text='\uF21E']"));
        click(moreInfoBtn);


    }

    public boolean isSearchFieldEmpty() {
        String searchFieldText = searchField.getText();
        return searchFieldText!="Search";
    }

}
