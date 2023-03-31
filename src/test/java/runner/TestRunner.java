package runner;

import io.cucumber.testng.CucumberOptions;

import tests.base.BaseTests;

@CucumberOptions(features="src/test/resources/features/registration/registration.feature"
        ,glue= {"steps"}
        ,plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
        ,tags = "@failed")
public class TestRunner extends BaseTests {
}