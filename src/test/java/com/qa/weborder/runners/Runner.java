package com.qa.weborder.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/weborder",
        glue = "com/qa/weborder/stepdefenitions",
        plugin = {"pretty", "html:target/uiReport.html", "rerun:target/uiFailedTests.txt",
        "json:target/cucumber-reports/cucumber.json"}

)
public class Runner {
}
