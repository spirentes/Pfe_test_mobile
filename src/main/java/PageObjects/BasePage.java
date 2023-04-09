package PageObjects;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class BasePage {
    RemoteWebDriver driver;
    public static final long WAIT = 60;

    public BasePage(RemoteWebDriver webDriver) {
        driver = webDriver;
    }

    public void waitForVisibility ( WebElement element ) {
        WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds ( WAIT ));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clear(WebElement element) {
        waitForVisibility(element);
        element.clear();
    }

    public void click(WebElement element) {
        waitForVisibility(element);
        element.click();
    }

    public void sendText(WebElement element, String text) {
        waitForVisibility(element);
        element.clear();
        element.sendKeys(text);
    }

    public String getAttribute(WebElement element, String attribute) {
        waitForVisibility(element);
        return element.getAttribute(attribute);
    }
    public boolean isClickable(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
    public void scroll_up (WebElement element,AndroidDriver driver)
    {
        int startX = element.getLocation().getX() + (element.getSize().getWidth() / 2);
        int startY = element.getLocation().getY() + (element.getSize().getHeight() / 2);
        int endX = startX;
        int endY = startY - 300; // You can adjust the distance of the scroll here

        TouchAction touchAction = new TouchAction(  driver);
        touchAction.longPress ( PointOption.point ( startX, startY ) )
                   .moveTo ( PointOption.point ( endX, endY ) )
                   .release()
                   .perform();
    }
}

