package runner.orgnization;

import io.cucumber.core.cli.Main;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import steps.organization.ManageOrganizationPageSteps;
import tests.base.BaseTests;
import java.net.MalformedURLException;
@org.testng.annotations.Test
@CucumberOptions(features="src/test/resources/features/organization/ManageOrganizationPage.feature"
        ,glue= {"steps.organization"}
        ,plugin= {"pretty","html:target/cucumber-html-report.html"})
public class TestRunner extends BaseTests {
    private ManageOrganizationPageSteps addOrganizationPageSteps;
   @BeforeClass
    @BeforeAll
    public static void  setup() throws MalformedURLException {
        System.out.println("setup function");
        configureAppium();
        System.out.println(driver);

    }

//    @After("@add_organization_from_plus_button")
//    public void afterAddOrganization() {
//        // This code will run after the "Add a new organization" scenario
//        System.out.println("Test on add organization dialog.... ");
//        String[] argv = {"-g", "steps.organization", "src/test/resources/features/organization/AddOrganizationDialog.feature"};
//        Main.run(argv, Thread.currentThread().getContextClassLoader());
//
//    }

}