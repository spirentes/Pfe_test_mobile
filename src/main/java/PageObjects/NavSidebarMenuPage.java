package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public
class NavSidebarMenuPage extends  BasePage{
    private AndroidDriver driver;

    @AndroidFindBy(xpath= "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]")
    private WebElement qrcodeScanner;

    @AndroidFindBy(xpath= "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]")
    private WebElement sites;

    @AndroidFindBy(xpath= "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]")
    private WebElement chargingStations;

    @AndroidFindBy(xpath= "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]")
    private WebElement sessionsHistory;

    @AndroidFindBy(xpath= "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]")
    private WebElement sessionsInProgress;

    @AndroidFindBy(xpath= "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]")
    private WebElement statistics;

    @AndroidFindBy(xpath= "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[7]")
    private WebElement users;

    @AndroidFindBy(xpath= "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[8]")
    private WebElement RFIDcards;

    @AndroidFindBy(xpath= "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[9]")
    private WebElement paymentMethods;

    @AndroidFindBy(xpath= "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[10]")
    private WebElement invoices;

    @AndroidFindBy (xpath= "//android.view.ViewGroup[@index='3']/android.widget.EditText")
    private WebElement userName;






    public
    NavSidebarMenuPage ( AndroidDriver driver ) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements ( new AppiumFieldDecorator ( driver), this );
    }

    public
    ScanChargingStations clickQRCodeScanner ( ) {
        click (qrcodeScanner );
        return new ScanChargingStations ( driver );
    }

    public
    SitesListPage clickSites ( ) {
       click ( sites);
        return new SitesListPage ( driver );
    }

    public
    SearchChargingStationsMapPage clickChargingStations ( ) {
        click ( chargingStations );
        return new SearchChargingStationsMapPage ( driver );
    }

    public
    SessionsHistoryListPage clickSessionsHistory ( ) {
        click ( sessionsHistory );
        return new SessionsHistoryListPage ( driver );
    }

    public
    SessionsInProgressListPage clickSessionsInProgress ( ) {
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

    public
    PaymentMethodsPage clickPaymentMethods ( ) {
        click ( RFIDcards);
        return new PaymentMethodsPage ( driver );
    }

    public
    InvoicesPage clickInvoices ( ) {
        click (invoices );
        return new InvoicesPage ( driver );
    }
    public boolean isOnPage() {
        try {
            // Check for the presence of the navMenuIcon element
            return userName.isDisplayed();
        } catch (NoSuchElementException e) {
            // The element is not present, so the page is not displayed
            return false;
        }
    }



}