package PageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.time.Duration;

public
class BasePage {
    RemoteWebDriver driver;
    public static final long WAIT = 120;

    public
    BasePage ( RemoteWebDriver webDriver ) {
        driver = webDriver;
    }

    public
    void waitForVisibility ( WebElement element ) {
        WebDriverWait wait = new WebDriverWait ( driver , Duration.ofSeconds ( WAIT ) );
        wait.until ( ExpectedConditions.visibilityOf ( element ) );
    }

    public
    void clear ( WebElement element ) {
        waitForVisibility ( element );
        element.clear ( );
    }

    public
    void click ( WebElement element ) {
        waitForVisibility ( element );
        element.click ( );
    }

    public
    void sendText ( WebElement element , String text ) {
        waitForVisibility ( element );
        element.sendKeys ( text );
    }

    public
    String getAttribute ( WebElement element , String attribute ) {
        waitForVisibility ( element );
        return element.getAttribute ( attribute );
    }

}
























