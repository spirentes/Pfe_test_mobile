package PageObjects.navBar;

import PageObjects.*;
import PageObjects.Paymentmethod.PaymentMethodsPage;
import PageObjects.charging_stations.ScanChargingStations;
import PageObjects.charging_stations.SearchChargingStationsMapPage;
import PageObjects.login.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public
class NavSidebarMenuPage extends BasePage {
    private AndroidDriver driver;

     @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Log Out\")")
    private WebElement logOutBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"QR-Code Scanner\")")
    private WebElement qrcodeScanner;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Sites\")")
    private WebElement sites;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Charging Stations\")")
    private WebElement chargingStations;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Sessions History\")")
    private WebElement sessionsHistory;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Sessions In Progress\")")
    private WebElement sessionsInProgress;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Statistics\")")
    private WebElement statistics;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Users\")")
    private WebElement users;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"RFID Cards\")")
    private WebElement RFIDcards;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Cars\")")
    private WebElement cars;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Payment Methods\")")
    private WebElement paymentMethods;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Invoices\")")
    private WebElement invoices;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Report Error\")")
    private WebElement reportError;

    @AndroidFindBy (accessibility = "RNE__Image")
    private  WebElement userName;






    public
    NavSidebarMenuPage ( AndroidDriver driver ) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator ( driver), this );
    }

    public ScanChargingStations clickQRCodeScanner ( ) {
        click (qrcodeScanner );
        return new ScanChargingStations ( driver );
    }

    public SitesListPage clickSites ( ) {
        click ( sites);
        return new SitesListPage ( driver );
    }

    public SearchChargingStationsMapPage clickChargingStations ( ) {
        click ( chargingStations );
        return new SearchChargingStationsMapPage ( driver );
    }

    public SessionsHistoryListPage clickSessionsHistory ( ) {
        click ( sessionsHistory );
        return new SessionsHistoryListPage ( driver );
    }

    public SessionsInProgressListPage clickSessionsInProgress ( ) {
        click (sessionsInProgress );
        return new SessionsInProgressListPage ( driver );
    }

    public
    StatisticsPage clickStatistics ( ) {
        click ( statistics );
        return new StatisticsPage ( driver );
    }

    public
    UsersListPage clickUsers ( ) {
        click (users );
        return new UsersListPage ( driver );
    }

    public
    RFIDCardsListPage clickRFIDCards ( ) {
        click ( RFIDcards);
        return new RFIDCardsListPage ( driver );
    }

    public PaymentMethodsPage clickPaymentMethods ( ) {
        click ( paymentMethods);
        return new PaymentMethodsPage ( driver );
    }

    public
    InvoicesPage clickInvoices ( ) {
        click (invoices );
        return new InvoicesPage ( driver );
    }
    public
    ReportErrorPage clickReportError ( ) {
        click (reportError );
        return new ReportErrorPage ( driver );
    }
    public LoginPage logOUt ( ) {
        click (logOutBtn );
        return new LoginPage ( driver );
    }
    public  boolean isOnPage() {
        try {
            // Check for the presence of the navMenuIcon element
            return qrcodeScanner.isDisplayed();
        } catch (NoSuchElementException e) {
            // The element is not present, so the page is not displayed
            return false;
        }
    }



}