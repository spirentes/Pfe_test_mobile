package runner.orgnization;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.BeforeAll;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import tests.base.BaseTests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@org.testng.annotations.Test
@CucumberOptions (features="src/test/resources/features/organization/NoOrganizationFoundDialog.feature"
        ,glue= {"steps.organization.noOrgFound"}
//        ,plugin= {"pretty","html:target/cucumber-html-report.html"}
        ,plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
//@Listeners (TestSuiteSetup.class)
public
class NoOrgTestRunner extends BaseTests {


//    @BeforeClass
//        @BeforeAll
//        public static void  setup() throws MalformedURLException, InterruptedException {
//            System.out.println("setup function");
//            configureAppium();
//            System.out.println(driver);
//
//        }
@BeforeClass

public static void openDriver() throws MalformedURLException {
    if (driver != null) {
        driver.quit(); // Close the previous driver instance if it exists
    }
    // Open the driver before each test
    driver = new AndroidDriver ( new URL ( "http://172.25.0.1:4444"), capabilities);
    driver.manage ( ).timeouts ( ).implicitlyWait ( Duration.ofSeconds ( 15 ) );
}


    @AfterClass
    public static void closeDriver() {
        if ( driver != null ) {
            driver.quit ( ); // Close the driver after each test

        }
    }

    }
