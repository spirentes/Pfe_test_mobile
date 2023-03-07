package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public
class FiltersPage {
    private AndroidDriver driver;
    private By             availableCS      = By.xpath ( "//android.widget.Switch[@index='3']" );
    private By            showRoamingCS    = By.xpath ( "//android.widget.Switch[@index='5']" );
    private By            type2Btn         = By.xpath ( "//android.view.ViewGroup[@index='6']" );
    private By            type2ComboCSSBtn = By.xpath ( "//android.view.ViewGroup[@index='7']" );
    private By            CHAdeMOBtn       = By.xpath ( "//android.view.ViewGroup[@index='8']" );
    private By            type1Btn         = By.xpath ( "//android.view.ViewGroup[@index='9']" );
    private By            type1ComboCSSBtn = By.xpath ( "//android.view.ViewGroup[@index='10']" );
    private By            domesticBtn      = By.xpath ( "//android.view.ViewGroup[@index='11']" );
    private By            type3CBtn        = By.xpath ( "//android.view.ViewGroup[@index='12']" );
    private By            unknownBtn       = By.xpath ( "//android.view.ViewGroup[@index='13']" );
    private By            applyBtn         = By.xpath ( "//android.view.ViewGroup[@index='14']/android.widget.Button" );
    private By            clearBtn         = By.xpath ( "//android.view.ViewGroup[@index='15']/android.widget.Button" );
    private By            exitBtn          =
            By.xpath ( "//android.view.ViewGroup[@index='1']/android.widget.TextView" );

    public
    FiltersPage ( AndroidDriver driver ) {
        this.driver = driver;
    }

    public
    void clickAvailableCS ( ) {
        driver.findElement ( availableCS ).click ( );
    }

    public
    void clickShowRoamingCS ( ) {
        driver.findElement ( showRoamingCS ).click ( );
    }

    public
    void selectType2 ( ) {
        driver.findElement ( type2Btn ).click ( );
    }

    public
    void selectType2ComboCSS ( ) {
        driver.findElement ( type2ComboCSSBtn ).click ( );
    }

    public
    void selectCHdeMo ( ) {
        driver.findElement ( CHAdeMOBtn ).click ( );
    }

    public
    void selectType1 ( ) {
        driver.findElement ( type1Btn ).click ( );
    }

    public
    void selectType1ComboCCS ( ) {
        driver.findElement ( type1ComboCSSBtn ).click ( );
    }

    public
    void selectDomestic ( ) {
        driver.findElement ( domesticBtn ).click ( );
    }

    public
    void selectType3C ( ) {
        driver.findElement ( type3CBtn ).click ( );
    }

    public
    void selectUnknown ( ) {
        driver.findElement ( unknownBtn ).click ( );
    }

    public
    SearchChargingStationsMapPage clickApply ( ) {
        driver.findElement ( applyBtn ).click ( );
        return new SearchChargingStationsMapPage ( driver );
    }

    public
    void clickClear ( ) {
        driver.findElement ( clearBtn ).click ( );
    }
    public
    SearchChargingStationsMapPage clickExit ( ) {
        driver.findElement ( exitBtn ).click ( );
        return new SearchChargingStationsMapPage ( driver );
    }


}
