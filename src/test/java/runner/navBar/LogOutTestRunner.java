package runner.navBar;

import io.cucumber.java.BeforeAll;
import io.cucumber.testng.CucumberOptions;

import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import tests.base.BaseTests;
//import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import java.net.MalformedURLException;

@CucumberOptions(features="src/test/resources/features/navBar/NavSidebarMenu.feature"
        ,glue= {"steps.navBar.LogOutStepDefs.java"}
        ,plugin= {"pretty","html:target/cucumber-html-report.html"} )

        public  class LogOutTestRunner {
}
