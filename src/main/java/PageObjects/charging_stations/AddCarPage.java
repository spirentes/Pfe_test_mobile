package PageObjects.charging_stations;

import PageObjects.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.sikuli.script.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AddCarPage extends BasePage {
    private AndroidDriver driver;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uE5C5\")")
    private WebElement carModelBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").text(\"Search\")")
    private WebElement searchField;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").text(\"Vehicle Identification Number\")")
    private WebElement VinField;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").text(\"License Plate\")")
    private WebElement LicensePlateField;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Switch\")")
    private WebElement DefaultCar;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Company car\")")
    private WebElement CompanyCar ;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Pool car\")")
    private WebElement PoolCar ;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Private car\")")
    private WebElement PrivateCar ;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Add car\")")
    private WebElement AddCarBtn ;

    public AddCarPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }
    public void choseCarModel(String carModel) throws FindFailed {
        click(carModelBtn);
        //sendText(searchField ,carModel);
        WebElement car = driver.findElement(MobileBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\""+carModel+" \")"));
        car.click();
//    Screen screen = new Screen();
//    Match element = screen.findText(carModel);
//    element.click();
    }
    public void  clickAddCar(){
        click(AddCarBtn);
    }
    public void setCarVin(String Vin){
        sendText(VinField,Vin);
    }
    public void setCarLicensePlate(String LicensePlate){
        sendText(LicensePlateField ,LicensePlate);
    }
    public void setDefaultCar(String defaultCar){
        if (defaultCar.equals("yes")){click(DefaultCar);}
    }
    public void setCarType(String carType)  {
        WebElement cartype =driver.findElement(MobileBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\""+carType+"\")"));
        click(cartype);
    }

}