package steps.users;

import PageObjects.charging_stations.SearchChargingStationsMapPage;
import PageObjects.users.UsersFilterPage;
import PageObjects.users.UsersListPage;
import PageObjects.navbar.NavSidebarMenuPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertTrue;
import static tests.base.BaseTests.driver;

public
class UsersStepdefs {
    UsersListPage   usersListPage   = new UsersListPage ( driver );
    UsersFilterPage usersFilterPage = new UsersFilterPage ( driver );

    @Before
    public
    void openUsersPage ( ) {
        SearchChargingStationsMapPage searchChargingStationsMapPage = new SearchChargingStationsMapPage ( driver );
        searchChargingStationsMapPage.clickNavBarBtn ( );
        NavSidebarMenuPage navSidebarMenuPage = new NavSidebarMenuPage ( driver );
        navSidebarMenuPage.clickUsers ( );
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

    @Given ( "User is  on the Users List Page")
    public
    void ImOnUsersPage ( ) {
        assertTrue ( usersListPage.isOnPage ( ) );
    }

    @Then ( "A list of  users  should be displayed {string}")
    public
    void aListOfUsersShouldBeDisplayed ( String userNameTxt ) {
        assertTrue ( usersListPage.isUserDisplayed ( userNameTxt ) );

    }


    @When ( "User click filterBtn")
    public
    void userClickFilterBtn ( ) {
        usersListPage.openFilterPage ( );
        assertTrue ( usersFilterPage.isOnPage ( ) );

    }

    @And ( "User enables the roaming users filter")
    public
    void userEnablesTheRoamingUsersFilter ( ) {
        usersFilterPage.selectRoamingUsers ( );
        assertTrue ( usersFilterPage.isRoamingUsersEnabled ( ) );
    }

    @And ( "User applies the filter")
    public
    void userAppliesTheFilter ( ) {
        usersFilterPage.clickApply ( );
        assertTrue ( usersListPage.isOnPage ( ) );
    }

    // wrong one
    // there is no roaming users
    @Then ( "Only the roaming users should be displayed in the list")
    public
    void onlyTheRoamingUsersShouldBeDisplayedInTheList ( ) {
        assertTrue ( usersListPage.noUsersMsgIsDisplayed ( ) );
    }

    @And ( "User clicks  the exit button")
    public
    void userClicksTheExitButton ( ) {
        usersFilterPage.clickExit ( );

    }

    @Then ( "User should be redirected to the Users List Page")
    public
    void userShouldBeRedirectedToTheUsersListPage ( ) {
        assertTrue ( usersListPage.isOnPage ( ) );
    }
}
