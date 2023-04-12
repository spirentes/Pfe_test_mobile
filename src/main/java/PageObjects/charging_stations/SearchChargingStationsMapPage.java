package PageObjects.charging_stations;
import org.openqa.selenium.*;
import PageObjects.BasePage;
import PageObjects.FiltersPage;
import PageObjects.charging_stations.ChargingStationsListPage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public
class SearchChargingStationsMapPage extends BasePage {

    private
    AndroidDriver driver;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.EditText\").text(\"Search\")")
    private  WebElement pageTitle;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Charging Stations\")")
    private        WebElement searchField;
    @AndroidFindBy (uiAutomator= "new UiSelector().className(\"android.widget.TextView\").text(\"\uDB80\uDE33\")")
    private WebElement filterIcon;
    @AndroidFindBy (uiAutomator= "new UiSelector().className(\"android.widget.TextView\").text(\"\uDB80\uDE79\")")
    private WebElement listViewIcon;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uF19C\")")
    private WebElement navBarIcon;
    @AndroidFindBy (xpath = "//android.view.ViewGroup[1]/android.widget.ImageView")
    private WebElement satelliteViewIcon;
    @AndroidFindBy (accessibility = "Google Map")
    private WebElement googleMap;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uDB80\uDD59\")")
    WebElement clearSearchField;
    @AndroidFindBy ( uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uF21E\")")
    WebElement heartbeatIcon;
     static WebElement CSIcon;
    WebElement availability_message;



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
    public
    boolean mapViewIsOnPage ( ) {
        try {
            // Check for the presence of the navMenuIcon element
            return googleMap.isDisplayed();
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
    public void  clickListViewIcon(){
        click (listViewIcon);

    }
    public void  clickSatelliteViewIcon(){
        click (satelliteViewIcon);

    }
    public
    void clearSearchField ( ) {
        click ( clearSearchField );

    }
    public boolean charging_station_is_on_map(String CSname){
//        String xpath2="//android.view.View[@content-desc=\""+CSname+" \"]";
//       CSIcon = driver.findElement(By.xpath(xpath2));
        CSIcon= driver.findElement(MobileBy.accessibilityId(CSname+". "));
        return CSIcon.isDisplayed();
    }
    public void tap_on_cs(String CSname)  {
        CSIcon= driver.findElement(MobileBy.accessibilityId(CSname+". "));
       CSIcon.click();

    }
    public boolean cs_name_is_displayed(String CSname){
        CSIcon= driver.findElement(MobileBy.androidUIAutomator("className(\"android.widget.TextView\").text(\""+CSname+"\")"));
        return CSIcon.isDisplayed();
    }

    public boolean connector_type_is_displayed() {
            String[] typesList = {"Type 1", "Type 2 - Combo CCS","Type 1 - Combo CCS","Type 2","CHAdeMo","Domestic","Type 3C","Unknown"};
            for (String type : typesList) {
                availability_message = null;
                try {
                    availability_message = driver.findElement(MobileBy.AndroidUIAutomator(
                            "new UiSelector().className(\"android.widget.TextView\").text(\"" + type + "\")"));
                    if (availability_message.isDisplayed()) {
                        return true;
                    }
                } catch (NoSuchElementException e) {
                    continue;
                }
            }
            return false;
    }
public boolean CS_is_available(String CSname) throws IOException{
        CSIcon= driver.findElement(MobileBy.accessibilityId(CSname+". "));
    int centerX = (int) (CSIcon.getLocation().getX() + CSIcon.getSize().getWidth() / 1.5);
    int centerY = (int) (CSIcon.getLocation().getY() + CSIcon.getSize().getHeight() / 1.5);
    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    BufferedImage image = ImageIO.read(scrFile);
    // Getting pixel color by position x and y
    int clr=  image.getRGB(centerX,centerY);
    int  red   = (clr & 0x00ff0000) >> 16;
    int  green = (clr & 0x0000ff00) >> 8;
    int  blue  =  clr & 0x000000ff;
    String RGB ="("+red+","+green+","+blue+")";
    System.out.println(RGB);
    if(RGB.equals("(139,139,139)"))
    {
        System.out.println("CS is not available ");
        return false;
    }
    else {
        System.out.println("CS is available ");
        return true;
    }
}
    public boolean ConnectorAvailability_is_displayed() {
        String[] availabilityList = {"Available", "Unavailable"};
        for (String availability : availabilityList) {
             availability_message = null;
            try {
                availability_message = driver.findElement(MobileBy.AndroidUIAutomator(
                        "new UiSelector().className(\"android.widget.TextView\").text(\"" + availability + "\")"));
                if (availability_message.isDisplayed()) {
                    return true;
                }
            } catch (NoSuchElementException e) {
                continue;
            }
        }
        return false;
    }
    public void clcikMoreInfoButton(String CsName)
    {

        String xpath ="//android.widget.TextView[@text='"+CsName+"']";
        System.out.println(xpath);
        WebElement parent_element= driver.findElement(By.xpath(xpath+"/.."));
        WebElement moreInfoBtn =parent_element.findElement(By.xpath("//android.widget.TextView[@text='\uE429']"));
        click(moreInfoBtn);


    }
   public boolean heartbeat_is_displayed()
   {
       return  heartbeatIcon.isDisplayed();
   }
}

