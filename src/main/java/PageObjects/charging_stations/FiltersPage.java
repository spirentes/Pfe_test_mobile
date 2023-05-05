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

import java.util.List;

public
class FiltersPage extends BasePage {
    private AndroidDriver driver;
    @AndroidFindBy(xpath = "//android.widget.Switch[@index='3']")
    private WebElement availableCS;
    @AndroidFindBy(xpath = "//android.widget.Switch[@index='5']")
    private WebElement showRoamingCS;
    WebElement type;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Apply\")")
    private WebElement applyBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Clear\")")
    private WebElement clearBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uF110\")")
    private WebElement exitBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Filters\")")
    private WebElement pageName;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\uE409\")")
    private WebElement chargePointBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"No Charging Station found\")")
    private WebElement noCsFound;
    WebElement connectortype;

    public FiltersPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickAvailableCS() {
        click(availableCS);
    }

    public void clickShowRoamingCS() {
        click(showRoamingCS);
    }


    public SearchChargingStationsMapPage clickApply() {
        click(applyBtn);
        return new SearchChargingStationsMapPage(driver);
    }

    public void clickClear() {
        click(clearBtn);
    }

    public void clickExit() {
        click(exitBtn);
    }

    public boolean isOnPage() {
        try {
            // Check for the presence of the navMenuIcon element
            return pageName.isDisplayed();
        } catch (NoSuchElementException e) {
            // The element is not present, so the page is not displayed
            return false;
        }
    }
    public boolean noCsFound_id_displayed()
    {
        return noCsFound.isDisplayed();
    }

    public void select_connector_type(String connectorType) {
        type = driver.findElement(MobileBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\"" + connectorType + "\")"));
        type.click();
    }

    public boolean only_cs_with_specified_connector_type_are_displayed(String type) {
        String xpath = "//android.widget.TextView[@text='Maximum']";
        List<WebElement> parents_element = driver.findElements(By.xpath(xpath + "/../.."));
        System.out.println("list is empty :"+parents_element.isEmpty());

        if (parents_element.isEmpty()) {
            return false;
        } else {
            for (WebElement element : parents_element) {
                connectortype = element.findElement(By.xpath("//android.view.ViewGroup[2]/android.widget.TextView"));
                if (!(connectortype.getAttribute("text").equals(type))) {
                    return false;
                }
            }
            return true;
        }
    }

    public boolean cs_with_specified_connectors_type_are_displayed(String type1,String type2) {
        String xpath = "//android.widget.TextView[@text='Maximum']";
        List<WebElement> parents_element = driver.findElements(By.xpath(xpath + "/../.."));
        System.out.println("list is empty :"+parents_element.isEmpty());

        if (parents_element.isEmpty()) {
            return false;
        } else {
            for (WebElement element : parents_element) {
                connectortype = element.findElement(By.xpath("//android.view.ViewGroup[2]/android.widget.TextView"));
                if (!(connectortype.getAttribute("text").equals(type1) || connectortype.getAttribute("text").equals(type2))) {
                    return false;
                }
            }
            return true;
        }

    }

}