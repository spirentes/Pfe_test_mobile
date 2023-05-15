package runner.orgnization;

import io.cucumber.java.BeforeAll;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import tests.base.BaseTests;

import java.net.MalformedURLException;

@org.testng.annotations.Test
@CucumberOptions (features="src/test/resources/features/organization/NoOrganizationFoundDialog.feature"
        ,glue= {"steps.organization.noOrgFound"}
        ,plugin= {"pretty","html:target/cucumber-html-report.html"})
//@Listeners (TestSuiteSetup.class)
public
class NoOrgTestRunner extends BaseTests {

//    @BeforeClass
//        @BeforeAll
//        public static void  setup() throws MalformedURLException {
//            System.out.println("setup function");
//            configureAppium();
//            System.out.println(driver);
//
//        }

    }
