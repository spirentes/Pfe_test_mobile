package PageObjects.organization;

import PageObjects.base.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ScanOraganizationPage extends BasePage {
    public AndroidDriver driver;
    @AndroidFindBy(xpath = "//android.widget.TextView[@index='1']")
    WebElement pageTitle;
    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.TextView[@bounds='[13,75][75,144]']")
    WebElement goBackBtn ;
    public ScanOraganizationPage(AndroidDriver driver ) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator( driver), this );
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
    public void return_to_organizations_page(){
//     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        goBackBtn = wait.until(ExpectedConditions.visibilityOf(goBackBtn));
        click(goBackBtn);
    }
}