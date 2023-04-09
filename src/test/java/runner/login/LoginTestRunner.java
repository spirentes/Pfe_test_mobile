package runner.login;

import io.cucumber.java.BeforeAll;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import tests.base.BaseTests;
import java.net.MalformedURLException;

import java.net.MalformedURLException;
@org.testng.annotations.Test
@CucumberOptions(features="src/test/resources/features/login/Login.feature"
        ,glue= {"steps.login"}
       // ,tags = "@Successful_login"
        ,plugin= {"pretty","html:target/cucumber-html-report.html"})
public class LoginTestRunner extends BaseTests {
    @BeforeClass
    @BeforeAll
    public  static void setup_driver () throws MalformedURLException {
        System.out.println("setting appium driver.....");
        configureAppium();
    }
}
