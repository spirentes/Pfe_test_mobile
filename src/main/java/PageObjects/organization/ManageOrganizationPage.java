package PageObjects.organization;

import PageObjects.base.BasePage;
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
    @AndroidFindBy (xpath = "//android.view.ViewGroup[@index='4']/android.widget.TextView")
    private WebElement    organisationBtn;
    @AndroidFindBy (xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup ")
    public WebElement    organizationOption1;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uDB81\uDC15\")")
    private WebElement    plusButton;
    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1][@bounds='[445,193][568,327]']")
    WebElement org1DeleteBtn;
    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]")
    WebElement org1updateBtn;
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

    public
    void clickOnOrganizationBtn ( ) {
        click (organisationBtn);
    }

    public
    void clickOnOrganizationOption1 ( ) {
        click ( organizationOption1 );
    }
    public
    void clickPlusButton () {
//      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        plusButton = wait.until(ExpectedConditions.elementToBeClickable(plusButton));
        click(plusButton);
    }
    public void swipeLeft(AndroidDriver driver)
    {
        Dimension screenSize = driver.manage().window().getSize();

        // Calculate the start and end points for the swipe gesture
        int startX = (int) (screenSize.width * 0.8);
        int endX = (int) (screenSize.width * 0.2);
        int startY = organizationOption1.getLocation().getY() + (organizationOption1.getSize().getHeight() / 2);
        int endY = startY;
        new TouchAction(driver)
                .press(PointOption.point(startX, startY))
                .waitAction()
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();
    }
    public void delete_organization()
    {
        click(org1DeleteBtn);
    }
    public  void update_organization(){
        click(org1updateBtn);
    }
}
