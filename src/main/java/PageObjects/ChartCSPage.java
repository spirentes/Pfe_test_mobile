package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public
class ChartCSPage extends BasePage{
    AndroidDriver driver;
    public
    ChartCSPage( AndroidDriver driver ) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator ( driver), this );
    }
}
