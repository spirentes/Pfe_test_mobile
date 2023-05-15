package runner.cars;

import io.cucumber.java.BeforeAll;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import tests.base.BaseTests;

import java.net.MalformedURLException;


@org.testng.annotations.Test
@CucumberOptions (features="src/test/resources/features/cars/cars.feature"
        ,glue= {"steps.cars"}
        ,plugin= {"pretty","html:target/cucumber-html-report.html"}
//        ,plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
//@Listeners (TestSuiteSetup.class)

public
class CarsTestRunner extends BaseTests {

//    @BeforeClass
//    @BeforeAll
//    public  static void setup_driver () throws MalformedURLException {
//        System.out.println("setting appium driver.....");
//        configureAppium();
//    }









}
