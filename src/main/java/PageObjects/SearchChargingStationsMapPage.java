package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public
class SearchChargingStationsMapPage extends  BasePage{
    private
    AndroidDriver driver;
    private By searchField = By.xpath ( "//android.view.ViewGroup[@index='3']/android.view.ViewGroup[@index='0']/android.widget.EditText" );
    private By filterIcon= By.xpath ( "//android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.widget.TextView" );
    private By listViewIcon =By.xpath ( "//android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.widget.TextView" );

    public
    SearchChargingStationsMapPage ( RemoteWebDriver webDriver ) {
        super ( webDriver );
    }


    public void setSearchField(){
        driver.findElement ( searchField ).sendKeys ( "sabri" );
    }
    public FiltersPage clickFilterIcon(){
        driver.findElement (filterIcon ).click ();
        return new FiltersPage ( driver );
    }
    public ChargingStationsListPage clickListViewIcon(){
        driver.findElement (listViewIcon ).click ();
        return new ChargingStationsListPage( driver );
    }


}