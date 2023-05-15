package runner.charging_stations;

import io.cucumber.java.BeforeAll;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import tests.base.BaseTests;

import java.net.MalformedURLException;
@CucumberOptions(features = "src/test/resources/features/Charging_stations/ChargePoint.feature",
        glue = {"steps.charging_stations.csPoint"},
        plugin = {"pretty","html:target/cucumber-html-report.html"}
)
public class ChargePointTestRunner extends BaseTests {
//    @BeforeClass
//    @BeforeAll
//    public  static void setup_driver () throws MalformedURLException {
//        System.out.println("setting appium driver.....");
//        configureAppium();
//        System.setProperty("myParameter", "myValue");
//    }

}