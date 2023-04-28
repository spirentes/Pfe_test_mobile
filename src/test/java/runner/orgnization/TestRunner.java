package runner.orgnization;

import io.cucumber.java.BeforeAll;
import io.cucumber.testng.CucumberOptions;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import runner.TestSuiteSetup;
import steps.organization.manageOrg.ManageOrganizationPageSteps;
import tests.base.BaseTests;
import java.net.MalformedURLException;
@org.testng.annotations.Test
@CucumberOptions(features="src/test/resources/features/organization/ManageOrganizationPage.feature"
        ,glue= {"steps.organization.manageOrg"}
        ,plugin= {"pretty","html:target/cucumber-html-report.html"})
@Listeners (TestSuiteSetup.class)
public class TestRunner extends BaseTests {
    @Override
    public void onStart ( ITestContext context ) {
        System.out.println("Test suite started");
    }
    private ManageOrganizationPageSteps addOrganizationPageSteps;
//   @BeforeClass
//    @BeforeAll
//    public static void  setup() throws MalformedURLException {
//        System.out.println("setup function");
//        configureAppium();
//        System.out.println(driver);
//
//    }

//    @After("@add_organization_from_plus_button")
//    public void afterAddOrganization() {
//        // This code will run after the "Add a new organization" scenario
//        System.out.println("Test on add organization dialog.... ");
//        String[] argv = {"-g", "steps.organization", "src/test/resources/features/organization/AddOrganizationDialog.feature"};
//        Main.run(argv, Thread.currentThread().getContextClassLoader());
//
//    }

}