package PageObjects.session;

import PageObjects.base.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public
class SessionsInProgressListPage extends BasePage {
    private   AndroidDriver driver;

    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Sessions In Progress\")")
    private  WebElement    pageTitle;
    @AndroidFindBy (xpath= "//android.view.ViewGroup[1]/android.widget.TextView[@index='0'][@bounds='[13,93][75,162]']")

    WebElement backBtn  ;

    public SessionsInProgressListPage( AndroidDriver driver ) {
        super(driver);
        this.driver = driver;
        System.out.println ( driver );
        PageFactory.initElements ( new AppiumFieldDecorator ( driver), this );
    }
    public void clickBackBtn()
    {click ( backBtn );}
    public
    boolean isOnPage ( ) {
        try {

            return pageTitle.isDisplayed();
        } catch ( NoSuchElementException e) {

            return false;
        }
    }


}
