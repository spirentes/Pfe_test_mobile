package steps.cars;

import PageObjects.RFID.RFIDCardsListPage;
import PageObjects.RFID.RfidFilterPage;
import PageObjects.RFID.SelectUsersPage;
import PageObjects.cars.CarsPage;
import PageObjects.charging_stations.AddCarPage;
import PageObjects.charging_stations.SearchChargingStationsMapPage;
import PageObjects.navbar.NavSidebarMenuPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoSuchElementException;
import org.sikuli.script.FindFailed;
import tests.base.BaseTests;

import static org.testng.Assert.assertTrue;

public
class CarsStepdefs extends BaseTests {

    CarsPage carsPage= new CarsPage ( driver );
    PageObjects.RFID.RfidFilterPage    RfidFilterPage    = new RfidFilterPage ( driver );
    SelectUsersPage selectUsersPage =new SelectUsersPage ( driver );
    AddCarPage     addCarPage      = new AddCarPage( driver);
    @Before
    public
    void openRFIDPage ( ) {
        SearchChargingStationsMapPage searchChargingStationsMapPage = new SearchChargingStationsMapPage ( driver );
        searchChargingStationsMapPage.clickNavBarBtn ( );
        NavSidebarMenuPage navSidebarMenuPage = new NavSidebarMenuPage ( driver );
        navSidebarMenuPage.clickCars ( );
        try {
            carsPage.btnOpenNonemptyFilterPage.click ( );
            RfidFilterPage.clickClear ( );
            RfidFilterPage.clickApply ( );
        } catch ( NoSuchElementException e ) {
            carsPage.openFilterPage ( );
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



    @Given ("User is  on the cars List Page")
    public
    void userIsOnTheCarsPage ( ) {
        assertTrue ( carsPage.isOnPage () );
    }

    @Then ("A list of cars should be displayed {string}")
    public
    void aListOfCarsShouldBeDisplayed ( String carsName ) {
        assertTrue ( carsPage.isCarsDisplayed ( carsName));
    }

    @When ("User search for the cars by {string}")
    public
    void userSearchForTheCarsBy ( String carsName ) {
        carsPage.setBtnClearSearchField ();
        carsPage.searchForCars (  carsName);
    }

    @Then ("the cars {string} should be displayed")
    public
    void theCarsShouldBeDisplayed ( String carsName ) {
        assertTrue (carsPage.isCarsDisplayed ( carsName )  );
       carsPage.setBtnClearSearchField ();
    }


    @When ("User  is on the User Selection Page")
    public
    void userIsOnTheUserSelectionPage ( ) {

        carsPage.openFilterPage ( );
        selectUsersPage = RfidFilterPage.selectUsers ( );
        assertTrue ( selectUsersPage.isOnPage ( ) );
    }

    @And ("User  enters {string} in the search field")
    public
    void userEntersInTheSearchField ( String userName) {
        selectUsersPage.setBtnClearSearchField ();
        selectUsersPage.searchForUser ( userName );
        driver.hideKeyboard ();
    }

    @And ("A list  of users containing {string} should be displayed")
    public
    void aListOfUsersContainingShouldBeDisplayed ( String userNames ) {
        assertTrue (selectUsersPage.isRFIDDisplayed ( userNames )  );
    }

    @And ("User  selects the user {string}")
    public
    void userSelectsTheUser ( String userName) {
        selectUsersPage.selectUser(userName);
        selectUsersPage.clickValidate ();
    }

    @Then ("The user  {string} should be selected")
    public
    void theUserShouldBeSelected ( String userNames) {
        assertTrue( RfidFilterPage.isUserDisplayed ( userNames ),"user not selected");
        RfidFilterPage.clickApply ();
        assertTrue ( carsPage.isCarsDisplayed ( userNames ));

    }

    @When ("user click on the add car btn")
    public
    void userClickOnTheAddCarBtn ( ) {
        carsPage.clickAddCar ();
    }

    @And ("when user chose a  {string}")
    public void whenUserChoseA(String carModel) throws FindFailed {
        addCarPage.choseCarModel(carModel);
    }

    @And ("user set the  {string} ,{string},{string},{string}")
    public void userSetThe(String vin, String licensePlate, String defaultCar, String carType) {
        addCarPage.setCarVin(vin);
        addCarPage.setCarLicensePlate(licensePlate);
        driver.hideKeyboard ();
        addCarPage.ScrollUp ();
        addCarPage.setDefaultCar(defaultCar);
        addCarPage.setCarType(carType);
        addCarPage.clickAddCar();
    }

    @Then ("the car should be  added {string}")
    public
    void theCarShouldBeAdded ( String licensePlate) {
        assertTrue ( carsPage.isCarsDisplayed (  licensePlate) );
    }
}