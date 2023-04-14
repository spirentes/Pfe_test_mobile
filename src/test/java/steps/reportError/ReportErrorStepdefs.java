package steps.reportError;

import PageObjects.SearchChargingStationsMapPage;
import PageObjects.navbar.NavSidebarMenuPage;
import PageObjects.reportError.ReportErrorPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertTrue;
import static tests.base.BaseTests.driver;

public
class ReportErrorStepdefs {
     ReportErrorPage reportErrorPage = new ReportErrorPage(driver);
    SearchChargingStationsMapPage searchChargingStationsMapPage= new SearchChargingStationsMapPage ( driver );
    @Before
    public void openReportErrorPage(){

        searchChargingStationsMapPage.clickNavBarBtn ();
        NavSidebarMenuPage navSidebarMenuPage= new NavSidebarMenuPage ( driver );
        navSidebarMenuPage.clickReportError ();
    }
    @After ("@failed")
    public void returnToMapPage()
    {
        System.out.println ( "im going back !!!!!!!!!!!" );
        driver.navigate ().back ();
    }

    @Given ("User is  on the Report Error Page")
    public
    void userIsOnTheReportErrorPage ( ) {

        assertTrue(reportErrorPage.isOnPage ());
    }


    @When ("the user enter  {string},{string} and {string}")
    public
    void theUserEnterAnd ( String mobile, String errorTitle, String description ) {
        reportErrorPage.enterMobileNumber (mobile);
        reportErrorPage.enterErrorTitle(errorTitle);
        reportErrorPage.enterDescription(description);

    }

    @And ("User clicks on Send Btn")
    public
    void userClicksOnSendBtn ( ) {
        reportErrorPage.clickSendButton ();
    }

    @Then ("The report should be sent and the user redirected to the charging station map Page")
    public
    void theReportShouldBeSent ( ) {

        // Add code to verify that the report was sent successfully

        assertTrue (searchChargingStationsMapPage.isOnPage () );
    }

    @Then ("An error message should be displayed")
    public
    void anErrorMessageShouldBeDisplayed ( ) {
        assertTrue ( reportErrorPage.isMobileNumberErrorDisplayed() );
        assertTrue ( reportErrorPage.isOnPage() );
    }

    @Then ("An error message should be displayed next to each empty field")
    public
    void anErrorMessageShouldBeDisplayedNextToEachEmptyField ( ) {
        assertTrue ( reportErrorPage.isErrorTitleErrorDisplayed()|| reportErrorPage.isDescriptionErrorDisplayed());
        assertTrue ( reportErrorPage.isOnPage () );
    }
}
