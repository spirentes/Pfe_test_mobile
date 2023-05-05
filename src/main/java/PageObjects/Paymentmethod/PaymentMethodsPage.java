package PageObjects.Paymentmethod;

import PageObjects.base.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public
class PaymentMethodsPage  extends BasePage {
    private AndroidDriver driver;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Payment methods\")")
    private WebElement pageTitle;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Payment methods\")")

    WebElement backBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uDB81\uDC15\")")
    WebElement plusBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.wattzhub.cpo:id/card_number_edit_text\")")
    WebElement cardNumber;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.wattzhub.cpo:id/expiry_date_edit_text\")")
    WebElement expirationDateFiled;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.wattzhub.cpo:id/cvc_edit_text\")")
    WebElement CVC;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uF1FC\")")
    WebElement licenseAgreement;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Save\")")
    WebElement saveBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"YES\")")
    WebElement yesBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"CANCEL\")")
    WebElement cancelBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uF589\")")
    WebElement deleteBtn;


    public PaymentMethodsPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickPlusBtn() {
        click(plusBtn);
    }

    public void clickBackBtn() {
        click(backBtn);
    }

    public void acceptLicenseAgreement() {
        click(licenseAgreement);
    }

    public void clickNoBtn() {
        click(cancelBtn);
    }

    public void clickYesBtn() {
        click(yesBtn);
    }

    public void clickSaveBtn() {
        click(saveBtn);
    }

    public void enterCardNumber(String CardNumber) {
        sendText(cardNumber, CardNumber);
    }

    public void enterExpirationDate(String date) {
        sendText(expirationDateFiled, date);
    }

    public void enterCVC(String cvc) {
        sendText(CVC, cvc);
    }

    public void deletePaymentMethod(String last4number) {
        Dimension screenSize = driver.manage().window().getSize();

        // Calculate the start and end points for the swipe gesture
        int startX = (int) (screenSize.width * 0.8);
        int endX = (int) (screenSize.width * 0.2);
        WebElement paymentMethod = driver.findElement(MobileBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\""+last4number+" \")"));
        int startY = paymentMethod.getLocation().getY() + (paymentMethod.getSize().getHeight() / 2);
        int endY = startY;
        new TouchAction(driver)
                .press(PointOption.point(startX, startY))
                .waitAction()
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();
        click(deleteBtn);
    }

    public boolean isOnPage() {
        try {

            return pageTitle.isDisplayed();
        } catch (NoSuchElementException e) {

            return false;
        }
    }

    public boolean newPyIsOnPage() throws FindFailed, InterruptedException {
        String imageFilePath = "C:\\Users\\Asus\\Downloads\\pfe-test-mobile-master\\resources\\pyAddedSuccessfully.png";
        Pattern pattern = new Pattern(imageFilePath);
        Thread.sleep(10000);
        Match match = new Screen().find(pattern);

        if (match.exists(pattern) != null) {
            // Click the button
            System.out.println("image found");
            return true;
        } else {
            // Print an error message if the button is not found
            System.out.println("Error: toast not found");
            return false;

        }
    }

    public boolean pyDeletedSuccessfully() throws FindFailed, InterruptedException {
        String imageFilePath = "C:\\Users\\Asus\\Downloads\\pfe-test-mobile-master\\resources\\pyRemovedSuccessfully.png";
        Pattern pattern = new Pattern(imageFilePath);
        // Thread.sleep(5000);
        //  Match match = new Screen().find(pattern);
        String timeoutInSeconds= "5";
        Match match = Screen.all().wait(pattern,5);
        if (match.exists(pattern) != null) {
            // Click the button
            System.out.println("image found");
            return true;
        } else {
            // Print an error message if the button is not found
            System.out.println("Error: toast not found");
            return false;

        }
    }
    public boolean saveIsDisabled(){
        if(saveBtn.getAttribute("clickable").equals("false"))
        {return true ;}
        return false;
    }
}