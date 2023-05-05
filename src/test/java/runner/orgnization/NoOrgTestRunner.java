package runner.orgnization;

import io.cucumber.testng.CucumberOptions;
import tests.base.BaseTests;

@org.testng.annotations.Test
@CucumberOptions (features="src/test/resources/features/organization/NoOrganizationFoundDialog.feature"
        ,glue= {"steps.organization.manageOrg"}
        ,plugin= {"pretty","html:target/cucumber-html-report.html"})
//@Listeners (TestSuiteSetup.class)
public
class NoOrgTestRunner extends BaseTests {
//    @Override
//    public void onStart ( ITestContext context ) {
//        System.out.println("Test suite started");
//    }
//    @BeforeClass
//        @BeforeAll
//        public static void  setup() throws MalformedURLException {
//            System.out.println("setup function");
//            configureAppium();
//            System.out.println(driver);
//
//        }

    }
