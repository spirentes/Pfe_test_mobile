package PageObjects.charging_stations;

import PageObjects.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public
class InfoChargingStationsPage extends BasePage {
    private AndroidDriver driver;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Vendor\")")
    private WebElement vendor;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Model\")")
    private WebElement Model;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Serial Number\")")
    private WebElement SerialNumber;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Firmware Version\")")
    private WebElement FirmwareVersion;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Private URL\")")
    private WebElement PrivateURL;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Public URL\")")
    private WebElement PublicURL;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"IP Route\")")
    private WebElement IPRoute;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"OCPP Version\")")
    private WebElement OCPPVersion;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Last Reboot\")")
    private WebElement LastReboot;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Created On\")")
    private WebElement CreatedOn;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Capabilities\")")
    private WebElement Capabilities;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"OCPP Standard Params\")")
    private WebElement OCPPStandardParams;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"OCPP Advanced Params\")")
    private WebElement OCPPAdvancedParams;


    public
    InfoChargingStationsPage ( AndroidDriver driver ) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator ( driver), this );
    }
    public boolean properties_are_displayed(){
        List<WebElement> properties= new ArrayList<>();
        properties.add(vendor);
        properties.add(Model);
        properties.add(SerialNumber);
        properties.add(FirmwareVersion);
        properties.add(PrivateURL);
        properties.add(PublicURL);
        properties.add(IPRoute);
        properties.add(OCPPVersion);
        properties.add(LastReboot);
        properties.add(CreatedOn);
        properties.add(Capabilities);
        properties.add(OCPPStandardParams);
        properties.add(OCPPAdvancedParams);
        for(WebElement element :properties)
        {
            if (!element.isDisplayed())
            {
                return false ;
            }
        }
        return true;
    }
}