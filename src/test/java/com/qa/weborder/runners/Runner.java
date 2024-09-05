package com.qa.weborder.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class) // it means runs with your Cucumber classes(feature files)
@CucumberOptions(
        features = "src/test/resources/features/smartbearsoftware",
        glue="com/qa/weborder/stepDef",
        plugin={"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt"})

    public class Runner {

    }

