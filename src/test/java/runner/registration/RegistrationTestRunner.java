package runner.registration;
import io.cucumber.java.BeforeAll;
import io.cucumber.testng.CucumberOptions;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import tests.base.BaseTests;
import java.net.MalformedURLException;
@org.testng.annotations.Test
@CucumberOptions(features="src/test/resources/features/registration/Registration.feature"
        ,glue= {"steps.registration"}
//       ,tags = "@successful_registration"
//        ,plugin= {"pretty","html:target/cucumber-html-report.html"}
        ,plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class RegistrationTestRunner extends  BaseTests{
//    @BeforeClass
//    @BeforeAll
//    public  static void setup_driver () throws MalformedURLException, InterruptedException {
//        System.out.println("setting appium driver.....");
//        configureAppium();
//    }

//    @Override
//    public
//    void onStart ( ITestContext context ) {
//
//    }
}
