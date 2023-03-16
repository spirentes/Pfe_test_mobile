package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public
class AddOrganizationPage {
    private AndroidDriver driver;
    private By            organisationBtn     =
            By.xpath ( "//android.view.ViewGroup[@index='4']/android.widget.TextView" );
    private By            organizationOption1 = By.xpath ( "" );

    public
    AddOrganizationPage ( AndroidDriver driver ) {
        this.driver = driver;
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
