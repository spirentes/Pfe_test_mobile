package runner.navBar;

import io.cucumber.java.BeforeAll;
import io.cucumber.testng.CucumberOptions;

import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import tests.base.BaseTests;
//import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import java.net.MalformedURLException;

import static tests.base.BaseTests.configureAppium;
import static tests.base.BaseTests.driver;

@CucumberOptions(features="src/test/resources/features/navBar/NavSidebarMenu.feature"
        ,glue= {"steps.navBar"}
        ,plugin= {"pretty","html:target/cucumber-html-report.html"} )

        public  class LogOutTestRunner {
        @BeforeClass
        @BeforeAll
        public static void  setup() throws MalformedURLException, InterruptedException {
                System.out.println("setup function");
                configureAppium();
                System.out.println(driver);

        }
}
