package PageObjects;

import PageObjects.charging_stations.SearchChargingStationsMapPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public
class FiltersPage extends BasePage{
    private AndroidDriver driver;
    @AndroidFindBy(xpath = "//android.widget.Switch[@index='3']")
    private WebElement    availableCS;
    @AndroidFindBy(xpath = "//android.widget.Switch[@index='5']")
    private WebElement    showRoamingCS;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='6']")
    private WebElement    type2Btn;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='7']")
    private WebElement    type2ComboCSSBtn;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='8']")
    private WebElement CHAdeMOBtn;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='9']")
    private WebElement type1Btn;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='10']")
    private WebElement type1ComboCSSBtn;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='11']")
    private WebElement domesticBtn;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='12']")
    private WebElement type3CBtn;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='13']")
    private WebElement unknownBtn;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='14']/android.widget.Button")
    private WebElement applyBtn;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='15']/android.widget.Button")
    private WebElement clearBtn;
    @AndroidFindBy (xpath = "//android.view.ViewGroup[@index='1']/android.widget.TextView")
    private WebElement exitBtn;
    @AndroidFindBy (xpath = "//android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[@index='0']")
    private WebElement pageName;


    public
    FiltersPage ( AndroidDriver driver ) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator ( driver), this );
    }

    public
    void clickAvailableCS ( ) {
        click (availableCS );
    }

    public
    void clickShowRoamingCS ( ) {
        click ( showRoamingCS);
    }

    public
    void selectType2 ( ) {
        click (type2Btn );
    }

    public
    void selectType2ComboCSS ( ) {
        click ( type2ComboCSSBtn );
    }

    public
    void selectCHdeMo ( ) {
        click (CHAdeMOBtn  );
    }

    public
    void selectType1 ( ) {
        click ( type1Btn );
    }

    public
    void selectType1ComboCCS ( ) {
        click ( type1ComboCSSBtn);
    }

    public
    void selectDomestic ( ) {
        click ( domesticBtn);
    }

    public
    void selectType3C ( ) {
        click (type3CBtn );
    }

    public
    void selectUnknown ( ) {
        click ( unknownBtn  );
    }

    public SearchChargingStationsMapPage clickApply ( ) {
        click (applyBtn );
        return new SearchChargingStationsMapPage ( driver );
    }

    public
    void clickClear ( ) {
        click ( clearBtn);
    }
    public
    SearchChargingStationsMapPage clickExit ( ) {
        click (exitBtn  );
        return new SearchChargingStationsMapPage ( driver );
    }
    public boolean isOnPage() {
        try {
            // Check for the presence of the navMenuIcon element
            return pageName.isDisplayed();
        } catch (NoSuchElementException e) {
            // The element is not present, so the page is not displayed
            return false;
        }
    }




}
