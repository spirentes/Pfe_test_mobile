package PageObjects.permissions;

import PageObjects.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public
class MediaAccessPermission extends BasePage {
    private AndroidDriver driver;

    private By permissionMessage = By.id( "com.android.packageinstaller:id/permission_message");
    private By allowButton       = By.id("com.android.packageinstaller:id/permission_allow_button");
    private By denyButton        = By.id("com.android.permissioncontroller:id/permission_deny_button");

    public MediaAccessPermission(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator ( driver), this );
    }

    public void allowMediaAccess() {
        driver.findElement(allowButton).click();
    }

    public void denyMediaAccess() {
        driver.findElement(denyButton).click();
    }
}

