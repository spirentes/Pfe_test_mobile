package runner.orgnization;

import io.cucumber.java.BeforeAll;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import tests.base.BaseTests;

import java.net.MalformedURLException;

@org.testng.annotations.Test
@CucumberOptions(features="src/test/resources/features/organization/AddOrganizationManuallyDialog.feature"
        ,glue= {"steps.organization.manually"}
        ,plugin= {"pretty","html:target/cucumber-html-report.html"})
public class TestRunner2  extends BaseTests {
    @BeforeClass
    @BeforeAll
    public  static void open_manually_dialog () throws MalformedURLException {
        System.out.println("before il class hhh");
        configureAppium();
    }


    }

