package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public
class AddOrganizationPage extends BasePage {
    private AndroidDriver driver;
    @AndroidFindBy (xpath = "//android.view.ViewGroup[@index='4']/android.widget.TextView")
    private WebElement    organisationBtn;
    @AndroidFindBy (xpath = " ")
    private WebElement    organizationOption1;




    public
    AddOrganizationPage ( AndroidDriver driver ) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator ( driver), this );
    }

    public
    void clickOnOrganizationBtn ( ) {
        System.out.println ( "driver is: " + driver );
        click (organisationBtn);
    }

    public
    void clickOnOrganizationOption1 ( ) {
        click ( organizationOption1 );
    }
}
