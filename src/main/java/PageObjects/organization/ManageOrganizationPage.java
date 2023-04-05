package PageObjects.organization;

import PageObjects.BasePage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public
class ManageOrganizationPage extends BasePage {
    private AndroidDriver driver;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Organizations\")")
    private WebElement pageTitle;
    @AndroidFindBy (xpath = "//android.view.ViewGroup[@index='4']/android.widget.TextView")
    private WebElement    organisationBtn;
    @AndroidFindBy (xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup ")
    public WebElement    organizationOption1;
    @AndroidFindBy (xpath = "//android.view.ViewGroup/android.view.ViewGroup[3][@bounds='[578,1334][691,1422]']")
    private WebElement    plusButton;
    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1][@bounds='[445,175][568,309]']")
    WebElement org1DeleteBtn;
    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]")
    WebElement org1updateBtn;
    public ManageOrganizationPage( AndroidDriver driver ) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator ( driver), this );
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
    void clickPlusButton ()
   {    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        plusButton = wait.until(ExpectedConditions.elementToBeClickable(plusButton));
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
