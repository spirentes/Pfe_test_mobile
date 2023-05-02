package steps.RFID;

import PageObjects.RFID.RFIDCardsListPage;
import PageObjects.RFID.RfidFilterPage;
import PageObjects.RFID.SelectUsersPage;
import PageObjects.SearchChargingStationsMapPage;
import PageObjects.navbar.NavSidebarMenuPage;
import PageObjects.sites.SitesFilterPage;
import PageObjects.sites.SitesListPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoSuchElementException;

import static org.testng.Assert.assertTrue;
import static tests.base.BaseTests.driver;


public
class RFIDStepdefs {
    RFIDCardsListPage RFIDCardsListPage   = new RFIDCardsListPage( driver );
    RfidFilterPage RfidFilterPage = new RfidFilterPage ( driver );
    SelectUsersPage selectUsersPage=new SelectUsersPage ( driver );
    @Before
    public
    void openRFIDPage ( ) {
        SearchChargingStationsMapPage searchChargingStationsMapPage = new SearchChargingStationsMapPage ( driver );
        searchChargingStationsMapPage.clickNavBarBtn ( );
        NavSidebarMenuPage navSidebarMenuPage = new NavSidebarMenuPage ( driver );
        navSidebarMenuPage.clickRFIDCards ( );
        try {
            RFIDCardsListPage.btnOpenNonemptyFilterPage.click ( );
            RfidFilterPage.clickClear ( );
            RfidFilterPage.clickApply ( );
        } catch ( NoSuchElementException e ) {
            RFIDCardsListPage.openFilterPage ( );
            RfidFilterPage.clickClear ( );
            RfidFilterPage.clickApply ( );
        }

    }
        @After
        public
        void clickBack ( ) {
            System.out.println ( "im going back !!!!!!!!!!!" );
            driver.navigate ( ).back ( );
        }
    @Given ("User is  on the RFID List Page")
    public
    void userIsOnTheRFIDListPage ( ) {
        assertTrue ( RFIDCardsListPage.isOnPage () );
    }

    @Then ("A list of  rfids should be displayed {string}")
    public
    void aListOfRfidsShouldBeDisplayed ( String rfidName ) {
        assertTrue ( RFIDCardsListPage.isSiteDisplayed ( rfidName ) );
    }

    @When ("User search for the rfid by {string}")
    public
    void userSearchForTheRfidBy ( String rfidName) {
        RFIDCardsListPage.searchForRFIDcard (rfidName  );


    }

    @Then ("the rfid {string} should be displayed")
    public
    void theRfidShouldBeDisplayed ( String rfidName) {
        assertTrue (RFIDCardsListPage.isSiteDisplayed ( rfidName )  );
        RFIDCardsListPage.setBtnClearSearchField ();
    }
}
