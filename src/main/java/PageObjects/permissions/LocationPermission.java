package PageObjects.permissions;

import PageObjects.base.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public
class LocationPermission extends BasePage {
    private AndroidDriver driver;




    public  By permissionMessage = By.id( "com.android.permissioncontroller:id/permission_message");
    private By onlyButton        = By.id( "com.android.permissioncontroller:id/permission_allow_foreground_only_button");
    private By  onetimeButton = By.id( "com.android.permissioncontroller:id/permission_allow_one_time_button");
    private By  denyButton = By.id( "com.android.permissioncontroller:id/permission_deny_button");



    public LocationPermission(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator ( driver), this );
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
