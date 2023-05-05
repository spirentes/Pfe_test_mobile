//package steps.charging_stations.csPoint;
//
//import PageObjects.charging_stations.ChargePointCSPage;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import tests.base.BaseTests;
//
//import static org.testng.Assert.assertTrue;
//
//public class CsPointSteps extends BaseTests {
//    ChargePointCSPage chargePointCSPage = new ChargePointCSPage(driver);
//    @Given("User is on the Charge Point Page")
//    public void userIsOnTheChargePointPage() {
//        assertTrue(chargePointCSPage.startSessionPageIsOnPage());
//    }
//
//
//    @When("user and RFID_card are active")
//    public void userAndRFID_cardAreActive() {
//        assertTrue(chargePointCSPage.user_and_RFID_are_active());
//    }
//
//    @And("user clicks start session")
//    public void userClicksStartSession() {
//        chargePointCSPage.clickStartSessionBtn();
//    }
//
//    @And("user clicks yes")
//    public void userClicksYes() {
//        chargePointCSPage.clickYesBtn();
//    }
//
//    @Then("a session should be started")
//    public void aSessionShouldBeStarted() {
//        assertTrue(chargePointCSPage.stopSessionIsOnPage());
//    }
//}
