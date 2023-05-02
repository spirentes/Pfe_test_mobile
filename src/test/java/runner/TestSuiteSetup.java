package runner;

import org.testng.ITestContext;
import org.testng.ITestNGListener;
import org.testng.annotations.BeforeSuite;
import tests.base.BaseTests;

import java.net.MalformedURLException;

public class TestSuiteSetup extends BaseTests
//        implements ITestNGListener
{
    @BeforeSuite
    public void setup() throws MalformedURLException {
        System.out.println("setup function");
        configureAppium();
        System.out.println(driver);
    }


//    @Override
//    public
//    void onStart ( ITestContext context ) {
//        System.out.println("Staaart");
//    }
}
