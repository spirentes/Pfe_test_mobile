package PageObjects;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class BasePage {
    RemoteWebDriver driver;
    public static final long WAIT = 10;

    public BasePage(RemoteWebDriver webDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(webDriver), this);
        driver = webDriver;
    }

    public void waitForVisibility(MobileElement element) {
        WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds ( WAIT ));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

        public void clear(MobileElement element) {
            waitForVisibility(element);
            element.clear();
        }

        public void click(MobileElement element) {
            waitForVisibility(element);
            element.click();
        }

        public void sendText(MobileElement element, String text) {
            waitForVisibility(element);
            element.sendKeys(text);
        }

        public String getAttribute(MobileElement element, String attribute) {
            waitForVisibility(element);
            return element.getAttribute(attribute);
        }

    }
























