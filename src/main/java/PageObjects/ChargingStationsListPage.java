package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public
class ChargingStationsListPage extends BasePage {
    private AndroidDriver driver;
    @AndroidFindBy ( xpath = "")
    WebElement navMenuIcon;
    @AndroidFindBy ( xpath = "")
    WebElement chargingStation;

    @AndroidFindBy ( xpath = "")
    WebElement scanChargingStation;

    @AndroidFindBy ( xpath = "")
    WebElement searchField;

    @AndroidFindBy ( xpath = "")
    WebElement filterIcon;
    @AndroidFindBy ( xpath = "")
    WebElement clearSearchField;

    @AndroidFindBy ( xpath = "")
    WebElement actionBtn;

    @AndroidFindBy ( xpath = "")
    WebElement heartbeatIcon;

    @AndroidFindBy ( xpath = "")
    WebElement moreInfo;
    @AndroidFindBy ( xpath = "")
    WebElement mapViewIcon;

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

    public
    ScanChargingStations openScanCS ( ) {
        click ( scanChargingStation );
        return new ScanChargingStations ( driver );

    }

    public
    void searchForCS ( String nameCS ) {
        clear ( searchField );
        sendText ( searchField , nameCS );
    }

    public
    FiltersPage openFilterPage ( ) {
        click ( filterIcon );
        return new FiltersPage ( driver );

    }

    public
    void clearSearchField ( ) {
        click ( clearSearchField );

    }

    public
    ActionsChargingStationsPage openActionPage ( ) {
        click ( actionBtn );
        return new ActionsChargingStationsPage ( driver );
    }

    public
    void StatusCS ( ) {
        click ( heartbeatIcon );
    }

    public
    ChargePointCSPage seeMoreInfo ( )
    {
        click ( moreInfo );
        return new ChargePointCSPage ( driver );
    }

    public
    SearchChargingStationsMapPage mapView ( )
    {
        click ( mapViewIcon );
        return new SearchChargingStationsMapPage ( driver );
    }
    public boolean isOnPage() {
        try {
            // Check for the presence of the navMenuIcon element
            return navMenuIcon.isDisplayed();
        } catch (NoSuchElementException e) {
            // The element is not present, so the page is not displayed
            return false;
        }
    }

    public boolean isCSDisplayed(String nameCS) {
        try {
            return chargingStation.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isSearchFieldEmpty() {
        String searchFieldText = searchField.getText();
        return searchFieldText.isEmpty();
    }

}
