package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public
class SessionsHistoryListPage extends BasePage{
    private AndroidDriver driver;

    public SessionsHistoryListPage( AndroidDriver driver ) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator ( driver), this );
    }
}
