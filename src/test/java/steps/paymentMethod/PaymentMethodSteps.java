package steps.paymentMethod;

import PageObjects.Paymentmethod.PaymentMethodsPage;
import PageObjects.charging_stations.SearchChargingStationsMapPage;
import PageObjects.navBar.NavSidebarMenuPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.sikuli.script.FindFailed;
import tests.base.BaseTests;

import static org.testng.Assert.assertTrue;

public class PaymentMethodSteps extends BaseTests {
    PaymentMethodsPage paymentMethodsPage =new PaymentMethodsPage(driver);
    SearchChargingStationsMapPage searchChargingStationsMapPage = new SearchChargingStationsMapPage(driver);
    NavSidebarMenuPage navSidebarMenuPage = new NavSidebarMenuPage(driver);
    @Before
    public  void gotoPyMethod(){
        searchChargingStationsMapPage.clickNavBarBtn();
        navSidebarMenuPage.clickPaymentMethods();
    }
    @After
    public void goback()
    {
        driver.navigate().back();
    }
    @After("@failed")
    public void goback2()
    {
        driver.navigate().back();
    }
    @Given("user is on the payment Methods page")
    public void userIsOnThePaymentMethodsPage() {
        assertTrue(paymentMethodsPage.isOnPage());
    }

    @When("user click on the plus button")
    public void userClickOnThePlusButton() {
        paymentMethodsPage.clickPlusBtn();
    }

    @And("user enters a {string},{string}and a {string}")
    public void userEntersAAndA(String cardNumber, String expDate, String cvc) {
        paymentMethodsPage.enterCardNumber(cardNumber);
        paymentMethodsPage.enterExpirationDate(expDate);
        paymentMethodsPage.enterCVC(cvc);
    }

    @And("user accepts the terms and  clicks save")
    public void userClicksSave() {
        paymentMethodsPage.acceptLicenseAgreement();
        paymentMethodsPage.clickSaveBtn();
    }

    @Then("a new payment method should be added")
    public void aNewPaymentMethodShouldBeAdded() throws FindFailed, InterruptedException {
        assertTrue(paymentMethodsPage.newPyIsOnPage());
    }


    @And("user swipe left the {string} then click the delete button")
    public void userSwipeLeftTheThenClickTheDeleteButton(String last4numbers) {
        paymentMethodsPage.deletePaymentMethod(last4numbers);
    }
    @And("user clicks  yes")
    public void userClicksYes() {
        paymentMethodsPage.clickYesBtn();
    }

    @Then("the {string} should be deleted")
    public void theShouldBeDeleted(String py) throws FindFailed, InterruptedException {
        assertTrue(paymentMethodsPage.pyDeletedSuccessfully());
    }


    @And("user enters a {string}or{string}or{string}")
    public void userEntersAOrOr(String invalidCardNumber, String invalidExpDay, String invalidCvc) {
        paymentMethodsPage.enterCardNumber(invalidCardNumber);
        paymentMethodsPage.enterExpirationDate(invalidExpDay);
        paymentMethodsPage.enterCVC(invalidCvc);

    }

    @Then("user can not add a payment method")
    public void userCanNotAddAPaymentMethod() {
        assertTrue(paymentMethodsPage.saveIsDisabled());
    }
}
