package PageObjects.cars;

import PageObjects.RFID.RfidFilterPage;
import PageObjects.base.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public
class CarsPage extends BasePage {



    private AndroidDriver driver ;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uDB80\uDE33\")")
    private WebElement btnOpenFilterPage;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uDB81\uDC15\")")
    private WebElement    plusButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").text(\"Search\")")
    private WebElement txtSearchField;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uDB80\uDD59\")")
    private WebElement btnClearSearchField;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uDB80\uDE32\")")
    public WebElement btnOpenNonemptyFilterPage;
    List<WebElement> carsNames ;
    WebElement       carName ;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Cars\")")
    WebElement pageTitle;
    public
    RfidFilterPage openNonEmptyFilterPage ( ) {
        click ( btnOpenNonemptyFilterPage);
        return new RfidFilterPage ( driver );

    }
    public void  clickAddCar() {
        click ( plusButton );

    }

    public
    void searchForCars( String nameCar) {
        clear ( txtSearchField );
        sendText ( txtSearchField , nameCar );
    }
    public void setBtnClearSearchField()
    {
        click ( btnClearSearchField );
    }

    public RfidFilterPage openFilterPage ( ) {
        click ( btnOpenFilterPage);
        return new RfidFilterPage ( driver );

    }
    public
    CarsPage ( AndroidDriver driver ) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator ( driver), this );
    }

    public
    boolean isOnPage ( ) {
        try {

            return pageTitle.isDisplayed();
        } catch ( NoSuchElementException e) {

            return false;
        }
    }  public boolean isCarsDisplayed(String carNameTxt) {

        try {
            carName = driver.findElement (
                    MobileBy.androidUIAutomator (
                            "new UiSelector().className(\"android.widget.TextView\").text(\"" + carNameTxt + "\")" ) );
            carsNames.add ( carName );
            return true;
        } catch ( NoSuchElementException e ) {
            System.out.println ( "car not found " );
            return false;
        }


    }}





