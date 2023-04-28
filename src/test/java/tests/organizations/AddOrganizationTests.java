package tests.organizations;

import org.testng.ITestContext;
import tests.base.BaseTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import PageObjects.organization.ManageOrganizationPage;

import java.net.MalformedURLException;

public class AddOrganizationTests extends BaseTests {

    ManageOrganizationPage addOrganizationPage;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        configureAppium();
        addOrganizationPage = new ManageOrganizationPage(driver);
    }

    @Test
    public void testChooseExistingOrganization(){
        addOrganizationPage.clickOnOrganizationBtn();

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        service.stop();
    }

    @Override
    public
    void onStart ( ITestContext context ) {

    }
}