package runner.RFID;

import io.cucumber.java.BeforeAll;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import tests.base.BaseTests;

import java.net.MalformedURLException;

@org.testng.annotations.Test
@CucumberOptions (features="src/test/resources/features/RFID/RFID.feature"
        ,glue= {"steps.RFID"}
//        ,plugin= {"pretty","html:target/cucumber-html-report.html"}
        ,plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
//@Listeners (TestSuiteSetup.class)
public
class RFIDTestRunner extends BaseTests {
    @BeforeClass
    @BeforeAll
    public  static void setup_driver () throws MalformedURLException, InterruptedException {
        System.out.println("setting appium driver.....");
        configureAppium();
    }
}
