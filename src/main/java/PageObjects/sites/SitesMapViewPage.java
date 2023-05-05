package PageObjects.sites;

import PageObjects.base.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public
class SitesMapViewPage extends BasePage {
    @AndroidFindBy (accessibility = "Google Map")
    private WebElement mapView;
    AndroidDriver driver;
    public
    SitesMapViewPage ( AndroidDriver driver ) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator ( driver), this );
    }
    public
    boolean isOnPage ( ) {
        try {

            return mapView.isDisplayed();
        } catch ( NoSuchElementException e) {

            return false;
        }
    }
}
