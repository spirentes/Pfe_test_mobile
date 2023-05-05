package steps.charging_stations.csPoint;

import PageObjects.ReportErrorPage;
import PageObjects.SessionPage;
import PageObjects.charging_stations.AddCarPage;
import PageObjects.charging_stations.ChargePointCSPage;
import PageObjects.charging_stations.ChargingStationsListPage;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.sikuli.script.FindFailed;
import tests.base.BaseTests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class MyStepdefs extends BaseTests {
    ChargePointCSPage chargePointCSPage= new ChargePointCSPage(driver);
    ChargingStationsListPage chargingStationsListPage = new ChargingStationsListPage(driver);
    ReportErrorPage reportErrorPage = new ReportErrorPage(driver);
    SessionPage sessionPage = new SessionPage(driver);
    AddCarPage addCarPage = new AddCarPage(driver);
    @BeforeAll
    public static void openChargePoint(){
       String myParameter = System.getProperty("myParameter");
       System.out.println(myParameter);
    }
    @Given("User is on the Charge Point Page")
    public void userIsOnTheChargePointPage() {
        assertTrue(chargePointCSPage.startSessionPageIsOnPage());
    }

    @When("user and RFID_card are active")
    public void userAndRFID_cardAreActive() {
        assertTrue(chargePointCSPage.user_and_RFID_are_active());
    }

    @And("user clicks start session")
    public void userClicksStartSession() {
        chargePointCSPage.clickStartSessionBtn();
        assertTrue(chargePointCSPage.StartTransAlertIsOnPage());
    }

    @And("user clicks yes")
    public void userClicksYes() {
        chargePointCSPage.clickYesBtn();
    }

    @Then("a session should be started")
    public void aSessionShouldBeStarted() {
        assertTrue(chargePointCSPage.stopSessionIsOnPage());
    }

    @Given("User is on the  stop Charge Point Page")
    public void userIsOnTheStopChargePointPage() {
        assertTrue(chargePointCSPage.stopSessionIsOnPage());

    }

    @When("user clicks on stop icon")
    public void userClicksOnStopIcon() {
        chargePointCSPage.clickStopSessionBtn();
        assertTrue(chargePointCSPage.StopTransAlertIsOnPage());

    }

    @Then("session is closed and user go back to start session page")
    public void sessionIsClosedAndUserGoBackToStartSessionPage() {
        assertTrue(chargePointCSPage.startSessionPageIsOnPage());
    }
    @When("{string} or RFID_card is inactive")
    public void orRFID_cardIsInactive(String userName) {
        //chargePointCSPage.clickInfoBtn();
      chargePointCSPage.select_user(userName);
      assertTrue(chargePointCSPage.user_or_RFID_is_Inactive());
    }
    @Then("start session btn is disabled  and user can not start session")
    public void startSessionBtnIsDisabledAndUserCanNotStartSession() throws FindFailed {
        assertTrue(chargePointCSPage.start_session_is_disabled());

    }


    @When("{string} is not associated with an RFID card")
    public void isNotAssociatedWithAnRFIDCard(String userName) {
        chargePointCSPage.select_user(userName);
    }

    @Then("no RFID card message should be displayed")
    public void noRFIDCardMessageShouldBeDisplayed() {
        assertTrue(chargePointCSPage.noRFIDMessage());
    }

    @When("user clicks on session icon")
    public void userClicksOnSessionIcon() {
        chargePointCSPage.clickMoveToSessionBtn();
    }

    @Then("user should be redirected to the session page and all thd information should be displayed")
    public void userShouldBeRedirectedToTheSessionPageAndAllThdInformationShouldBeDisplayed() {
   assertTrue(sessionPage.isOnPage());
   driver.navigate().back();
    }

    @When("user clicks on report error icon")
    public void userClicksOnReportErrorIcon() {
     chargePointCSPage.clickReportErrorBtn();
    }

    @Then("user should be redirected to the report error page")
    public void userShouldBeRedirectedToTheReportErrorPage() {
        assertTrue(reportErrorPage.isOnPage());
    }

    @When("user click on the  add car btn")
    public void userClickOnTheAddBtn() {
        chargePointCSPage.click_add_car();
    }

    @And("when user chose a {string}")
    public void whenUserChoseA(String carModel) throws FindFailed {
        addCarPage.choseCarModel(carModel);
    }
    @And("user set the {string} ,{string},{string},{string}")
    public void userSetThe(String vin, String licensePlate, String defaultCar, String carType) {
        addCarPage.setCarVin(vin);
        addCarPage.setCarLicensePlate(licensePlate);
        addCarPage.setDefaultCar(defaultCar);
        addCarPage.setCarType(carType);
        addCarPage.clickAddCar();
    }

    @Then("the car should be added")
    public void theCarShouldBeAdded() {

    }


}
