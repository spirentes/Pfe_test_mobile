package PageObjects;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
//
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.pagefactory.AndroidFindBy;
//import io.appium.java_client.pagefactory.AppiumFieldDecorator;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.PageFactory;

public
class ScanChargingStations extends BasePage {
    private AndroidDriver driver;
    @AndroidFindBy (xpath= "//android.view.ViewGroup[1]/android.widget.TextView[@index='1'][@bounds='[122,104][468,151]']")

    WebElement pageTitle  ;
    @AndroidFindBy (xpath= "//android.view.ViewGroup[1]/android.widget.TextView[@index='0']")

    WebElement backBtn  ;

    public
    ScanChargingStations ( AndroidDriver driver ) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator ( driver), this );
    }
public void clickBackBtn()
{click ( backBtn );}
    public
    boolean isOnPage ( ) {
        try {
            // Check for the presence of the navMenuIcon element
            return pageTitle.isDisplayed();
        } catch (NoSuchElementException e) {
            // The element is not present, so the page is not displayed
            return false;
        }
    }
}
