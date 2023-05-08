package PageObjects.organization;

import PageObjects.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public
class ManageOrganizationPage extends BasePage {
    private AndroidDriver driver;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Organizations\")")
    private WebElement pageTitle;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uF12F\")")
    private WebElement backBtn;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uDB81\uDC15\")")
    private WebElement plusButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uF589\")")
    WebElement orgDeleteBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uE3C9\")")
    WebElement orgupdateBtn;
    List<WebElement> OrgNames ;
    WebElement       OrgName ;
    public ManageOrganizationPage( AndroidDriver driver ) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator ( driver), this );
    }
    public boolean selectOption(String orgNameTxt) {

        try {
            OrgName = driver.findElement (
                    MobileBy.androidUIAutomator (
                            "new UiSelector().className(\"android.widget.TextView\").text(\"" + orgNameTxt + "\")" ) );
            click ( OrgName );
            OrgNames.add ( OrgName );
            return true;
        } catch ( NoSuchElementException e ) {
            System.out.println ( "Organization not found " );
            return false;
        }
    }



    public boolean isOnPage() {
        try {
            // Check for the presence of the alertTitle element
            return pageTitle.isDisplayed();
        } catch (NoSuchElementException e) {
            // The element is not present, so the alert is not displayed
            return false;
        }
    }

public void clickBackBtn(){
        click(backBtn);
}

    public
    void clickPlusButton () {
        click(plusButton);
    }
    public void swipeLeft(String orgName)
    {
        Dimension screenSize = driver.manage().window().getSize();
        WebElement organization;
        try {
             organization =driver.findElement( MobileBy.androidUIAutomator (
                    "new UiSelector().className(\"android.widget.TextView\").text(\"" + orgName + "\")" ));
            // Calculate the start and end points for the swipe gesture
            int startX = (int) (screenSize.width * 0.8);
            int endX = (int) (screenSize.width * 0.2);
            int startY = organization.getLocation().getY() + (organization.getSize().getHeight() / 2);
            int endY = startY;
            new TouchAction(driver)
                    .press(PointOption.point(startX, startY))
                    .waitAction()
                    .moveTo(PointOption.point(endX, endY))
                    .release()
                    .perform();
        } catch (NoSuchElementException e){
            System.out.println("no organization found to be updated or deleted");
        }


    }
    public  void Pick_organization(String orgName){
        swipeLeft(orgName);
    }
    public void click_update_btn(){
        try {
            click(orgupdateBtn);
        }
        catch (NoSuchElementException e){

        }

    }
    public void delete_organization()
    {
        click(orgDeleteBtn);
    }
    public boolean org_is_deleted(String orgName){
        try {
            OrgName = driver.findElement (
                    MobileBy.androidUIAutomator (
                            "new UiSelector().className(\"android.widget.TextView\").text(\"" + orgName + "\")" ) );
            return false;
        } catch ( NoSuchElementException e ) {
            System.out.println ( "Organization deleted " );
            return true;
        }

    }
public boolean org_is_updated (String orgName){
    try {
        OrgName = driver.findElement (
                MobileBy.androidUIAutomator (
                        "new UiSelector().className(\"android.widget.TextView\").text(\"" + orgName + "\")" ) );
        return true;
    } catch ( NoSuchElementException e ) {
        System.out.println ( "Organization  " );
        return false;
    }

}
}