package PageObjects.charging_stations;

import PageObjects.base.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.*;

import java.time.Duration;
import java.util.List;

public class ChargePointCSPage extends BasePage {
    private AndroidDriver driver;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uDB80\uDEDA\")")
    private WebElement moveToSessionPageBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uE001\")")
    private WebElement reportErrorBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uE037\")")
    private WebElement startSessionBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uE047\")")
    private WebElement stopSessionBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"START TRANSACTION\")")
    private WebElement startTransAlertTitle;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"STOP TRANSACTION\")")
    private WebElement stopTransAlertTitle;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"YES\")")
    private WebElement yesBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"NO\")")
    private WebElement noBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Add a car\")")
    private WebElement AddCarBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uE5C5\")")
    private WebElement infoBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"An RFID card is required to recharge\")")
    private WebElement noRFID_card_message;

    public ChargePointCSPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);


    }

    public void clickMoveToSessionBtn() {
        click(moveToSessionPageBtn);
    }
    public void clickInfoBtn(){click(infoBtn);}
    public void clickStartSessionBtn() {
        click(startSessionBtn);
    }
    public void clickStopSessionBtn() {
        click(stopSessionBtn);
    }
    public void clickReportErrorBtn() {
        click(reportErrorBtn);
    }
    public void clickYesBtn() {
        click(yesBtn);
    }
    public void clickNoBtn() {
        click(noBtn);
    }
    public void click_add_car(){click(AddCarBtn);}
    public boolean startSessionPageIsOnPage() {
        try {
            // Check for the presence of the alertTitle element
            return startSessionBtn.isDisplayed();
        } catch (NoSuchElementException e) {
            // The element is not present, so the alert is not displayed
            return false;
        }
    }
    public void showCpInfo(){

    }
    public void select_user(String username){
        String xPath="//android.widget.ImageView[@resource-id=\"RNE__Image\"]";
        WebElement displayedUser =driver.findElement(By.xpath(xPath));
        displayedUser.click();
        WebElement user = driver.findElement(MobileBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\""+username+"\")"));
        click(user);
    }
    public boolean stopSessionIsOnPage() {
        try {
            // Check for the presence of the alertTitle element
            return stopSessionBtn.isDisplayed();
        } catch (NoSuchElementException e) {
            // The element is not present, so the alert is not displayed
            return false;
        }
    }
    public boolean StartTransAlertIsOnPage() {
        try {
            // Check for the presence of the alertTitle element
            return startTransAlertTitle.isDisplayed();
        } catch (NoSuchElementException e) {
            // The element is not present, so the alert is not displayed
            return false;
        }
    }
    public boolean StopTransAlertIsOnPage() {
        try {
            // Check for the presence of the alertTitle element
            return stopTransAlertTitle.isDisplayed();
        } catch (NoSuchElementException e) {
            // The element is not present, so the alert is not displayed
            return false;
        }
    }
    public boolean user_and_RFID_are_active()
    {

        List<WebElement> inactive = driver.findElements(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\"Inactive\")"));
        return inactive.isEmpty();
    }
    public boolean user_or_RFID_is_Inactive()
    {
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10)); // Wait up to 10 seconds
        List<WebElement> inactive = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\"Inactive\")")));
        return !inactive.isEmpty();
    }
    public boolean start_session_is_disabled() throws FindFailed {
        String imageFilePath = "C:\\Users\\Asus\\Downloads\\pfe-test-mobile-master\\resources\\disabled_start_session_btn.png";
        //Color maskColor = new Color(133, 133, 133);
// Create a Pattern object using the image file path and specify the color range
        Pattern pattern = new Pattern(imageFilePath); // example color range: red

// Find the matching element
        Match match = new Screen().find(pattern);
        if (match.exists(pattern) != null) {
            // Click the button
            System.out.println("image found");
            return true ;
        } else {
            // Print an error message if the button is not found
            System.out.println("Error: button not found");
            return false;

        }
    }
    public  boolean noRFIDMessage(){
        waitForVisibility(noRFID_card_message);
        return noRFID_card_message.isDisplayed();
    }
}