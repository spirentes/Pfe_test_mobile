package runner.orgnization;

import io.cucumber.java.BeforeAll;
import io.cucumber.testng.CucumberOptions;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import runner.TestSuiteSetup;
import tests.base.BaseTests;

import java.net.MalformedURLException;

@org.testng.annotations.Test
@CucumberOptions(features="src/test/resources/features/organization/AddOrganizationManuallyDialog.feature"
        ,glue= {"steps.organization.manually"}
        ,plugin= {"pretty","html:target/cucumber-html-report.html"})
//@Listeners (TestSuiteSetup.class)
public class TestRunner2  extends BaseTests {
//    @Override
//    public void onStart ( ITestContext context ) {
//        System.out.println("Test suite started");
//    }
    @BeforeClass
    @BeforeAll
    public  static void open_manually_dialog () throws MalformedURLException {
        System.out.println("before il class hhh");
        configureAppium();
    }


    }

