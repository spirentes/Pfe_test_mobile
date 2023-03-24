package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public
class AddOrganizationPage extends BasePage {
    private AndroidDriver driver;
    private By            organisationBtn     =
            By.xpath ( "//android.view.ViewGroup[@index='4']/android.widget.TextView" );
    private By            organizationOption1 = By.xpath ( "" );

    public
    AddOrganizationPage ( AndroidDriver driver ) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator ( driver), this );
    }

    public
    void clickOnOrganizationBtn ( ) {
        System.out.println ( "driver is: " + driver );
        driver.findElement ( organisationBtn ).click ( );
    }

    public
    void clickOnOrganizationOption1 ( ) {
        driver.findElement ( organizationOption1 ).click ( );
    }
}
