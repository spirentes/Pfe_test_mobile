package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
public class ChargePointCSPage extends BasePage {
    private AndroidDriver driver;
    @AndroidFindBy (xpath = "")
    private WebElement    reportErrorBtn;
    @AndroidFindBy (xpath = "")
    private WebElement    sessionBtn;
    public ChargePointCSPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator ( driver), this );

    }
    public ReportErrorPage clickReportErrorBtn() {
        click(reportErrorBtn);
        return new ReportErrorPage (driver);
    }
    public SessionPage clickSessionBtn() {
        click(sessionBtn);
        return new SessionPage (driver);
    }
}