package runner.login;

import io.cucumber.java.BeforeAll;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import tests.base.BaseTests;

import java.net.MalformedURLException;

@org.testng.annotations.Test
@CucumberOptions(features="src/test/resources/features/login/Login.feature"
        ,glue= {"steps.login"}
       // ,tags = "@Successful_login"
        ,plugin= {"pretty","html:target/cucumber-html-report.html"})
//@Listeners (TestSuiteSetup.class)
public class LoginTestRunner extends BaseTests {
//    @Override
//    public void onStart ( ITestContext context ) {
//        System.out.println("Test suite started");
//    }
//    @BeforeClass
//    @BeforeAll
//    public  static void setup_driver () throws MalformedURLException {
//        System.out.println("setting appium driver.....");
//        configureAppium();
//    }
}
