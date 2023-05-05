package PageObjects.reportError;

import PageObjects.base.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public
class ReportErrorPage extends BasePage {
    private AndroidDriver driver ;

    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Report Error\")")
    WebElement pageTitle;
    @AndroidFindBy (xpath= "//android.view.ViewGroup[@index='1']/android.widget.EditText")
    WebElement mobileField;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"The mobile is invalid\")")
    WebElement mobileFieldError;
    @AndroidFindBy (xpath= "//android.view.ViewGroup[2]/android.widget.EditText")
    WebElement errorTitleField;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"The subject is mandatory\")")
    WebElement errorTitleFieldError;
    @AndroidFindBy (xpath= "//android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText")
    WebElement descriptionField;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"The description is mandatory\")")
    WebElement descriptionFieldError;
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Send\")")
    WebElement sendBtn;


    public
    ReportErrorPage ( AndroidDriver driver ) {
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
    }
    public void enterMobileNumber(String mobileNumber) {

       sendText (mobileField,mobileNumber);
    }

    public boolean isMobileNumberErrorDisplayed() {
        try {
            return mobileFieldError.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void enterErrorTitle(String errorTitle) {
      sendText (errorTitleField,errorTitle);
    }

    public boolean isErrorTitleErrorDisplayed() {
        try {
            return errorTitleFieldError.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void enterDescription(String description) {

       sendText (descriptionField,description);
    }

    public boolean isDescriptionErrorDisplayed() {
        try {
            return descriptionFieldError.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickSendButton() {
        sendBtn.click();
    }
}