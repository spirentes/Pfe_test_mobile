package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public
class SitesListPage extends BasePage{
    private        AndroidDriver driver;
    //wrong xpath !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    @AndroidFindBy (xpath= "//android.widget.TextView[@index='1'][@bounds='[122,104][200,151]']")
    private  WebElement    pageTitle;
    @AndroidFindBy (xpath= "//android.view.ViewGroup[1]/android.widget.TextView[@index='0'][@bounds='[13,93][75,162]']")

    WebElement backBtn  ;
    public
    SitesListPage ( AndroidDriver driver ) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator ( driver), this );

    }
    public void clickBackBtn()
    {click ( backBtn );}

    public
    boolean isOnPage ( ) {
        try {

            return pageTitle.isDisplayed();
        } catch ( NoSuchElementException e) {

            return false;
        }
    }
}
