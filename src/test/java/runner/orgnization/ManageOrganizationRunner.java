package runner.orgnization;

import io.cucumber.java.BeforeAll;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import steps.organization.manageOrg.ManageOrganizationPageSteps;
import tests.base.BaseTests;
import java.net.MalformedURLException;
@org.testng.annotations.Test
@CucumberOptions(features="src/test/resources/features/organization/ManageOrganizationPage.feature"
        ,glue= {"steps.organization.manageOrg"}
//        ,plugin= {"pretty","html:target/cucumber-html-report.html"}
        ,plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class ManageOrganizationRunner extends BaseTests {

//    @BeforeClass
//    @BeforeAll
//    public static void  setup() throws MalformedURLException, InterruptedException {
//        System.out.println("setup function");
//        configureAppium();
//        System.out.println(driver);
//
//    }

}