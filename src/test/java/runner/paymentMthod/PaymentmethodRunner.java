package runner.paymentMthod;

import io.cucumber.java.BeforeAll;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import tests.base.BaseTests;

import java.net.MalformedURLException;

@CucumberOptions(features = "src/test/resources/features/paymentMethods/paymentMethod.feature",
        glue = {"steps.paymentMethod"},
        tags = "@tag",
        plugin = {"pretty","html:target/cucumber-html-report.html"})

public class PaymentmethodRunner extends BaseTests {
    @BeforeClass
    @BeforeAll
    public  static void setup_driver () throws MalformedURLException {
        System.out.println("setting appium driver.....");
        configureAppium();
    }
}