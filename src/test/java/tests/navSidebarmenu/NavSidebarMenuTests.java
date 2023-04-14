package tests.navSidebarmenu;

import tests.base.BaseTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import PageObjects.navbar.NavSidebarMenuPage;

import java.net.MalformedURLException;

public
class NavSidebarMenuTests extends BaseTests {
    NavSidebarMenuPage NavSidebarMenuPage;

    @BeforeClass
    public
    void setUp ( ) throws MalformedURLException {
        configureAppium ( );
        NavSidebarMenuPage = new NavSidebarMenuPage ( driver );
    }
    @Test
    public
    void testOpenQRCodeScanner ( ) {
        NavSidebarMenuPage.clickQRCodeScanner ();
    }
    @Test
    public
    void testOpenSites ( ) {
        NavSidebarMenuPage.clickSites ();
    }
    @Test
    public
    void testOpenChargingStations ( ) {
        NavSidebarMenuPage.clickChargingStations ();
    }
    @Test
    public
    void testOpenSessionsHistory ( ) {
        NavSidebarMenuPage.clickSessionsHistory ();
    }
    @Test
    public
    void testOpenSessionsInProgress ( ) {
        NavSidebarMenuPage.clickSessionsInProgress ();
    }
    @Test
    public
    void testOpenStatistics( ) {
        NavSidebarMenuPage.clickStatistics ();
    }
    @Test
    public
    void testOpenUsers( ) {
        NavSidebarMenuPage.clickUsers ();
    }
    @Test
    public
    void testOpenRFIDCards ( ) {
        NavSidebarMenuPage.clickRFIDCards ();
    }
    @Test
    public
    void testOpenPaymentMethods( ) {
        NavSidebarMenuPage.clickPaymentMethods ();
    }
    @Test
    public
    void testOpenInvoices ( ) {
        NavSidebarMenuPage.clickInvoices ();
    }

}
