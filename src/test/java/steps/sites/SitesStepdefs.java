package steps.sites;

import PageObjects.SearchChargingStationsMapPage;
import PageObjects.navbar.NavSidebarMenuPage;
import PageObjects.sites.SitesAreaPage;
import PageObjects.sites.SitesFilterPage;
import PageObjects.sites.SitesListPage;
import PageObjects.sites.SitesMapViewPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoSuchElementException;
import org.testng.ITestContext;
import tests.base.BaseTests;


import static org.testng.Assert.assertTrue;


public
class SitesStepdefs extends BaseTests {
    SitesListPage   sitesListPage   = new SitesListPage ( driver );
    SitesFilterPage sitesFilterPage = new SitesFilterPage ( driver );
    SitesAreaPage   sitesAreaPage   = new SitesAreaPage ( driver );
    SitesMapViewPage sitesMapViewPage=new SitesMapViewPage ( driver );

    @Before
    public
    void openSitesPage ( ) {
        SearchChargingStationsMapPage searchChargingStationsMapPage = new SearchChargingStationsMapPage ( driver );
        searchChargingStationsMapPage.clickNavBarBtn ( );
        NavSidebarMenuPage navSidebarMenuPage = new NavSidebarMenuPage ( driver );
        navSidebarMenuPage.clickSites ( );
        try {
            sitesListPage.btnOpenNonemptyFilterPage.click ( );
            sitesFilterPage.clickClear ( );
            sitesFilterPage.clickApply ( );
        } catch ( NoSuchElementException e ) {
            sitesListPage.openFilterPage ( );
            sitesFilterPage.clickClear ( );
            sitesFilterPage.clickApply ( );
        }


    }

    @After
    public
    void clickBack ( ) {
//        if (usersFilterPage.isOnPage ()){
//        usersFilterPage.clickClear ();
//        usersFilterPage.clickApply ();}
        System.out.println ( "im going back !!!!!!!!!!!" );
        driver.navigate ( ).back ( );
    }

    @Given ("User is  on the Sites List Page")
    public
    void userIsOnTheSitesListPage ( ) {
        assertTrue ( sitesListPage.isOnPage ( ) );
    }


    @Then ("A list of  sites should be displayed {string}")
    public
    void aListOfSitesShouldBeDisplayed ( String siteNameTxt ) {
        assertTrue ( sitesListPage.isSiteDisplayed ( siteNameTxt ) );
    }


    @When ("User search for the site by {string}")
    public
    void userSearchForTheSiteBy ( String siteName ) {
        sitesListPage.searchForSite ( siteName );

    }

    @Then ("the site {string} should be displayed")
    public
    void theSiteShouldBeDisplayed ( String siteName ) {
        assertTrue ( sitesListPage.isSiteDisplayed ( siteName ) );
        sitesListPage.setBtnClearSearchField ( );
    }

    @And ("All site's info should be displayed")
    public
    void allSiteSInfoShouldBeDisplayed ( ) {
        assertTrue ( sitesListPage.SiteInfoIsDisplayed ( ) );

    }

    @When ("User  click filterBtn")
    public
    void userClickFilterBtn ( ) {
        sitesListPage.openFilterPage ( );
        assertTrue ( sitesFilterPage.isOnPage ( ) );
    }

    @And ("User  enables the roaming users filter")
    public
    void userEnablesTheRoamingUsersFilter ( ) {
        sitesFilterPage.selectRoamingSites ( );
        assertTrue ( sitesFilterPage.isRoamingSitesEnabled ( ) );
    }

    @And ("User  applies the filter")
    public
    void userAppliesTheFilter ( ) {
        sitesFilterPage.clickApply ( );
        assertTrue ( sitesListPage.isOnPage ( ) );
    }

    // wrong one
    // there is no roaming users
    @Then ("Only  the roaming users should be displayed in the list")
    public
    void onlyTheRoamingUsersShouldBeDisplayedInTheList ( ) {
        assertTrue ( sitesListPage.noSitesMsgIsDisplayed ( ) );
    }

    @And ("User clicks   the exit button")
    public
    void userClicksTheExitButton ( ) {
        sitesFilterPage.clickExit ( );
    }

    @Then ("User  should be redirected to the Users List Page")
    public
    void userShouldBeRedirectedToTheSitesListPage ( ) {
        assertTrue ( sitesListPage.isOnPage ( ) );
    }


    @When ("User  click to open site area of {string}")
    public
    void userClickToOpenSiteAreaOf ( String siteName ) {
        System.out.println ( siteName );
        sitesListPage.clickBtnOpenSiteArea ();

    }


    @Then ("User  should be redirected to the Site area List Page : {string}")
    public
    void userShouldBeRedirectedToTheSiteAreaListPage ( String siteName ) {
        assertTrue ( sitesAreaPage.isSiteDisplayed ( siteName ) );
    }

    @When ("user switch to the sites map page")
    public
    void userSwitchToTheSitesMapPage ( ) {
        sitesListPage.clickBtnSwitchToMapPage ();
    }

    @Then ("User  should be redirected to the Sites Map Page")
    public
    void userShouldBeRedirectedToTheSitesMapPage ( ) {
        assertTrue ( sitesMapViewPage.isOnPage ());
    }


}
