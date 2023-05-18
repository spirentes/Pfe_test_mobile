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
        ,plugin= {"pretty","html:target/cucumber-html-report.html"}
//        ,plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdaypter:"}
)
//@Listeners (TestSuiteSetup.class)
public class LoginTestRunner extends BaseTests {

    @BeforeClass
    @BeforeAll
    public  static void setup_driver () throws MalformedURLException, InterruptedException {
        System.out.println("setting appium driver.....");
        configureAppium();
    }
}
