package PageObjects.cars;

import PageObjects.base.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public
class CarsPage extends BasePage {



    private AndroidDriver driver ;

    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Cars\")")
    WebElement pageTitle;
    public
    CarsPage ( AndroidDriver driver ) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator ( driver), this );
    }

    public
    boolean isOnPage ( ) {
        try {

            return pageTitle.isDisplayed();
        } catch ( NoSuchElementException e) {

            return false;
        }
    }
}

