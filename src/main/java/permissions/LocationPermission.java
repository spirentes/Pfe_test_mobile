package permissions;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;

public
class LocationPermission {
    private AndroidDriver driver;




    public  By permissionMessage = By.id( "com.android.permissioncontroller:id/permission_message");
    private By onlyButton        = By.id( "com.android.permissioncontroller:id/permission_allow_foreground_only_button");
    private By  onetimeButton = By.id( "com.android.permissioncontroller:id/permission_allow_one_time_button");
    private By  denyButton = By.id( "com.android.permissioncontroller:id/permission_deny_button");



    public LocationPermission(AndroidDriver driver){
        this.driver =driver;
    }
    public void foregroundOnly(){
        driver.findElement(onlyButton).click();
    }
    public void onetimeOnly(){
        driver.findElement(onetimeButton).click();
    }
    public void denyLocation(){
        driver.findElement(denyButton).click();
    }


}
