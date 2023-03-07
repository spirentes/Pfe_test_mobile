package organizations;

import base.BaseTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddOrganizationPage;

import java.net.MalformedURLException;

public class AddOrganizationTests extends BaseTests {

    AddOrganizationPage addOrganizationPage;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        configureAppium();
        addOrganizationPage = new AddOrganizationPage(driver);
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
}
