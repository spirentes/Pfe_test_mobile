package PageObjects;

import io.appium.java_client.android.AndroidDriver;
        import io.appium.java_client.pagefactory.AndroidFindBy;
        import io.appium.java_client.pagefactory.AppiumFieldDecorator;
        import org.openqa.selenium.By;
        import org.openqa.selenium.NoSuchElementException;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.remote.RemoteWebDriver;
        import org.openqa.selenium.support.PageFactory;

public
class SearchChargingStationsMapPage extends  BasePage{

    private
    AndroidDriver driver;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.EditText\").text(\"Search\")")
    private  WebElement pageTitle;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Charging Stations\")")
    private        WebElement searchField;
    @AndroidFindBy (xpath= "//android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.widget.TextView")
    private WebElement filterIcon;
    @AndroidFindBy (xpath= "//android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.widget.TextView")
    private WebElement listViewIcon;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uF19C\")")
    private WebElement navBarIcon;



    public
    SearchChargingStationsMapPage ( AndroidDriver driver ) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator ( driver), this );
    }

    public
    boolean isOnPage ( ) {
        try {
            // Check for the presence of the navMenuIcon element
            return pageTitle.isDisplayed();
        } catch ( NoSuchElementException e) {
            // The element is not present, so the page is not displayed
            return false;
        }
    }
    public void clickNavBarBtn(){
        click ( navBarIcon );
    }



    public void setSearchField(){
        sendText ( searchField,"mycompany101" );
    }
    public FiltersPage clickFilterIcon(){
        click (filterIcon);
        return new FiltersPage ( driver );
    }
    public ChargingStationsListPage clickListViewIcon(){
        click (listViewIcon);
        return new ChargingStationsListPage( driver );
    }


}

