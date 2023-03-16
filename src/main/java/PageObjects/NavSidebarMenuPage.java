package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public
class NavSidebarMenuPage {
    private AndroidDriver driver;
    private By            qrcodeScanner      =
            By.xpath ( "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]" );
    private By            sites              =
            By.xpath ( "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]" );
    private By            chargingStations   =
            By.xpath ( "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]" );
    private By            sessionsHistory    =
            By.xpath ( "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]" );
    private By            sessionsInProgress =
            By.xpath ( "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]" );
    private By            statistics         =
            By.xpath ( "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]" );
    private By            users              =
            By.xpath ( "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[7]" );
    private By            RFIDcards          =
            By.xpath ( "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[8]" );
    private By            paymentMethods     =
            By.xpath ( "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[9]" );
    private By            invoices           =
            By.xpath ( "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[10]" );

    public
    NavSidebarMenuPage ( AndroidDriver driver ) {
        this.driver = driver;
    }

    public
    ScanChargingStations clickQRCodeScanner ( ) {
        driver.findElement ( qrcodeScanner ).click ( );
        return new ScanChargingStations ( driver );
    }

    public
    SitesListPage clickSites ( ) {
        driver.findElement ( sites ).click ( );
        return new SitesListPage ( driver );
    }

    public
    SearchChargingStationsMapPage clickChargingStations ( ) {
        driver.findElement ( chargingStations ).click ( );
        return new SearchChargingStationsMapPage ( driver );
    }

    public
    SessionsHistoryListPage clickSessionsHistory ( ) {
        driver.findElement ( sessionsHistory ).click ( );
        return new SessionsHistoryListPage ( driver );
    }

    public
    SessionsInProgressListPage clickSessionsInProgress ( ) {
        driver.findElement ( sessionsInProgress ).click ( );
        return new SessionsInProgressListPage ( driver );
    }

    public
    StatisticsPage clickStatistics ( ) {
        driver.findElement ( statistics ).click ( );
        return new StatisticsPage ( driver );
    }

    public
    UsersListPage clickUsers ( ) {
        driver.findElement ( users ).click ( );
        return new UsersListPage ( driver );
    }

    public
    RFIDCardsListPage clickRFIDCards ( ) {
        driver.findElement ( RFIDcards ).click ( );
        return new RFIDCardsListPage ( driver );
    }

    public
    PaymentMethodsPage clickPaymentMethods ( ) {
        driver.findElement ( RFIDcards ).click ( );
        return new PaymentMethodsPage ( driver );
    }

    public
    InvoicesPage clickInvoices ( ) {
        driver.findElement ( invoices ).click ( );
        return new InvoicesPage ( driver );
    }


}