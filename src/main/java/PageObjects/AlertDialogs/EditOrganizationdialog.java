package PageObjects.AlertDialogs;

import PageObjects.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class EditOrganizationdialog extends BasePage {
    private AndroidDriver driver;
    @AndroidFindBy(uiAutomator ="new UiSelector().className(\"android.widget.TextView\").text(\"EDIT ORGANIZATION\")")
    WebElement AlertTitle ;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.widget.EditText")
    WebElement subDomainField ;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.widget.EditText")
    WebElement nameField ;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.widget.Button")
    WebElement saveButton;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]/android.widget.Button")
    WebElement cancelButton ;
    public
    EditOrganizationdialog ( AndroidDriver driver ) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator( driver), this );
    }
    public boolean isOnPage() {
        try {
            // Check for the presence of the alertTitle element
            return AlertTitle.isDisplayed();
        } catch (NoSuchElementException e) {
            // The element is not present, so the alert is not displayed
            return false;
        }
    }
    public
    void click_save_button ( ) {
        click (saveButton );
    }
    public
    void click_cancel_button ( ) {
        click (cancelButton );
    }
    public void updateSubDomainField ( String subDomain ) {
        sendText (subDomainField,subDomain);
    }

    public
    void updateNameField ( String name ) {
        sendText (nameField, name );
    }
}
