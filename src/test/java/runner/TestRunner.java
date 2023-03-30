package runner;

import io.cucumber.testng.CucumberOptions;

import tests.base.BaseTests;

@CucumberOptions(features="src/test/resources/features/registration.feature"
        ,glue= {"steps"}
        ,plugin= {"pretty","html:target/cucumber-html-report.html"}
        ,tags = "@failed")
public class TestRunner extends BaseTests {
}