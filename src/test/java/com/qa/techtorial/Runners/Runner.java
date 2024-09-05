package com.qa.techtorial.Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class) // it means runs with your Cucumber classes(feature files)
@CucumberOptions(
        //it is an annotation that has some special keywords
        features = "src/test/resources/features",  //This is location of future files we provide with "Content Root"
        glue = "com/qa/techtorial/stepdefenitions", // this is location of "Step Definitions" folder. We provide with "SOURCE ROOT'
        dryRun = false, //It gets the snips without executing the steps
        tags = "@regression", // it is filtration for your scenarios / regression / smoke
        plugin = {"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt"}
)
public class Runner {

}
