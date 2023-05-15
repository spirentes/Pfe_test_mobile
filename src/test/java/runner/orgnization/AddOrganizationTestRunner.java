package runner.orgnization;

import io.cucumber.java.BeforeAll;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import tests.base.BaseTests;

import java.net.MalformedURLException;

@org.testng.annotations.Test
@CucumberOptions(features="src/test/resources/features/organization/AddOrganizationDialog.feature"
        ,glue= {"steps.organization.addOrg"}
        ,plugin= {"pretty","html:target/cucumber-html-report.html"})
public class AddOrganizationTestRunner extends BaseTests {
//    @BeforeClass
//    @BeforeAll
//    public  static void open_manually_dialog () throws MalformedURLException {
//        System.out.println("before il class hhh");
//        configureAppium();
//    }


}