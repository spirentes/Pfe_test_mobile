package runner.TestSuite;
import org.testng.ITestNGListener;

import org.testng.annotations.BeforeSuite;
import tests.base.BaseTests;

import java.net.MalformedURLException;

public class TestSuiteSetup extends BaseTests implements ITestNGListener
{

    @BeforeSuite
    public void setup() throws MalformedURLException, InterruptedException {
        System.out.println("setup function");
        configureAppium();
        System.out.println(driver);
    }}