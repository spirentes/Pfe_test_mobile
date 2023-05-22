package runner.charging_stations;

import io.cucumber.java.BeforeAll;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import tests.base.BaseTests;

import java.net.MalformedURLException;

@org.testng.annotations.Test
@CucumberOptions(features="src/test/resources/features/Charging_stations/CSMap.feature"
        ,glue= {"steps.charging_stations.mapView"}
        //,tags = "@tag"
        ,plugin= {"pretty","html:target/cucumber-html-report.html"})
public class CSmapViewTestRunner extends BaseTests {
//    @BeforeClass
//    @BeforeAll
//    public  static void setup_driver () throws MalformedURLException, InterruptedException {
//        System.out.println("setting appium driver.....");
//        configureAppium();
//    }
}