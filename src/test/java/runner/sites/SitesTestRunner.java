package runner.sites;

import io.cucumber.java.BeforeAll;
import io.cucumber.testng.CucumberOptions;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import tests.base.BaseTests;

import java.net.MalformedURLException;
@org.testng.annotations.Test
@CucumberOptions (features="src/test/resources/features/sites/Sites.feature"
        ,glue= {"steps.sites"}
        ,plugin= {"pretty","html:target/cucumber-html-report.html"})

public
class SitesTestRunner extends BaseTests {
//    @BeforeClass
//    @BeforeAll
//    public  static void setup_driver () throws MalformedURLException {
//        System.out.println("setting appium driver.....");
//        configureAppium();
//    }


}
