package runner.TestSuite;
import org.testng.ITestNGListener;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import tests.base.BaseTests;

import java.net.MalformedURLException;

public class TestSuiteSetup extends BaseTests {
@BeforeClass
    @Parameters ({"udid","platformVersion" })
    @BeforeSuite

    public void setup(String udid, String platformVersion) throws MalformedURLException, InterruptedException {
        System.out.println("setup function");
        configureAppium(udid,platformVersion);

    }}