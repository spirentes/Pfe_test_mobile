package permissions;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public
class MediaAccessPermission {
    private AndroidDriver driver;

    private By permissionMessage = By.id( "com.android.packageinstaller:id/permission_message");
    private By allowButton       = By.id("com.android.packageinstaller:id/permission_allow_button");
    private By denyButton        = By.id("com.android.permissioncontroller:id/permission_deny_button");

    public MediaAccessPermission(AndroidDriver driver) {
        this.driver = driver;
    }

    public void allowMediaAccess() {
        driver.findElement(allowButton).click();
    }

    public void denyMediaAccess() {
        driver.findElement(denyButton).click();
    }
}

