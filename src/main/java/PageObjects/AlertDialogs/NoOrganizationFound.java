package PageObjects.AlertDialogs;

import PageObjects.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public
class NoOrganizationFound extends BasePage {
    AndroidDriver driver ;
    public
    NoOrganizationFound ( AndroidDriver driver ) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator ( driver), this );
    }
}
