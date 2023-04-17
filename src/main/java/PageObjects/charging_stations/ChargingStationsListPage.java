package PageObjects.charging_stations;

import PageObjects.*;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public
class ChargingStationsListPage extends BasePage {
    private AndroidDriver driver;
    @AndroidFindBy ( uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uF19C\")")
    WebElement navMenuIcon;

//    @AndroidFindBy ( xpath = "")
//    WebElement scanChargingStation;
    @AndroidFindBy ( xpath = "//android.view.ViewGroup[1]/android.widget.EditText")
    WebElement searchField;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uDB80\uDE33\")")
    WebElement filterIcon;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uDB80\uDD59\")")
    WebElement clearSearchField;
    @AndroidFindBy ( uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uDB80\uDF4D\")")
    WebElement mapViewIcon;
    @AndroidFindBy ( uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"HEARTBEAT\")")
     public WebElement heartBeat;
    @AndroidFindBy ( uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"No Charging Station found\")")
    public WebElement noCsFound;
    WebElement CSname;
    WebElement heartbeatIcon;
    List<WebElement> CSnames;

    public
    ChargingStationsListPage ( AndroidDriver driver ) {
        super ( driver );
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator ( driver ) , this );
    }

    public
    void openNavMenu ( ) {
        click ( navMenuIcon );
    }
    public
    void searchForCS ( String nameCS ) {
        clear ( searchField );
        sendText ( searchField , nameCS );
    }

    public void openFilterPage ( ) {
        click ( filterIcon );
    }

    public
    void clearSearchField ( ) {
        click ( clearSearchField );

    }

    public
    SearchChargingStationsMapPage mapView ( )
    {
        click ( mapViewIcon );
        return new SearchChargingStationsMapPage ( driver );
    }
    public boolean isOnPage() {
        try {
            // Check for the presence of the navMenuIcon element
            return mapViewIcon.isDisplayed();
        } catch (NoSuchElementException e) {
            // The element is not present, so the page is not displayed
            return false;
        }
    }
    public boolean heartBeatIsOnPage() {
        try {
            // Check for the presence of the navMenuIcon element
            return heartBeat.isDisplayed();
        } catch (NoSuchElementException e) {
            // The element is not present, so the page is not displayed
            return false;
        }
    }
//    public boolean isCSDisplayed()
//    {
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            CSname1 = wait.until(ExpectedConditions.visibilityOf(CSname1));
//            // do something with the element
//            return true;
//
//        } catch (TimeoutException e) {
//            System.out.println("Element not found.");
//            return false;
//        }
//    }

    public boolean isCSDisplayed(String CsName) {

        try {
            CSname =driver.findElement(MobileBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\""+CsName+"\")"));
            CSnames.add(CSname);
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("charging station not found ");
            return false;
        }
    }
    public void clcikMoreInfoButton(String CsName)
    {

        String xpath ="//android.widget.TextView[@text='"+CsName+"']";
        System.out.println(xpath);
        WebElement parent_element= driver.findElement(By.xpath(xpath+"/.."));
        WebElement moreInfoBtn =parent_element.findElement(By.xpath("//android.widget.TextView[@text='\uE429']"));
        click(moreInfoBtn);


    }
    public void clickHeartbeatBtn(String CsName)
    {

        String xpath ="//android.widget.TextView[@text='"+CsName+"']";
        System.out.println(xpath);
        WebElement parent_element= driver.findElement(By.xpath(xpath+"/.."));
        WebElement heartBeatIcon =parent_element.findElement(By.xpath("//android.widget.TextView[@text='\uF21E']"));
        click(heartBeatIcon);


    }

    public boolean isSearchFieldEmpty() {
        String searchFieldText = searchField.getText();
        return searchFieldText!="Search";
    }
    //!!!!!! not working with heart beat icon
//    public boolean CS_is_available(String CSname) throws IOException {
//       try {
//           String xpath ="//android.widget.TextView[@text='"+CSname+"']";
//           WebElement parent_element= driver.findElement(By.xpath(xpath+"/.."));
//            heartbeatIcon =parent_element.findElement(By.xpath("//android.widget.TextView[@text='\uF21E']"));
//       }
//       catch (NoSuchElementException e)
//       {System.out.println("cant find cs icon");}
//        int centerX = (int) (heartbeatIcon.getLocation().getX() + heartbeatIcon.getSize().getWidth() / 1.5);
//        int centerY = (int) (heartbeatIcon.getLocation().getY() + heartbeatIcon.getSize().getHeight() / 1.5);
//        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        BufferedImage image = ImageIO.read(scrFile);
//        // Getting pixel color by position x and y
//        int clr=  image.getRGB(centerX,centerY);
//        int  red   = (clr & 0x00ff0000) >> 16;
//        int  green = (clr & 0x0000ff00) >> 8;
//        int  blue  =  clr & 0x000000ff;
//        String RGB ="("+red+","+green+","+blue+")";
//        System.out.println(RGB);
//        if(RGB.equals("(139,139,139)"))
//        {
//            System.out.println("CS is not available ");
//            return false;
//        }
//        else {
//            System.out.println("CS is available ");
//            return true;
//        }
//    }

}
