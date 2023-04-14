package PageObjects.sites;

import PageObjects.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public
class SitesAreaPage extends BasePage {
AndroidDriver     driver;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uDB80\uDD59\")")
    private WebElement btnClearSearchField;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").text(\"Search\")")
    private WebElement txtSearchField;
    List<WebElement> siteNames ;
    WebElement    siteName ;
    public
    SitesAreaPage ( AndroidDriver driver ) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator ( driver), this );
    }
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




}
