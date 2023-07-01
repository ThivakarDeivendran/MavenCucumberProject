package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		
		features=".//Features//Customers.feature",
		glue ="stepDefinitions",
	    dryRun =false,
		monochrome= true,
		plugin= {"pretty","html:target/cucumber-reports"},
		publish =true
		)
public class TestRunClass {
	
}


//"html:target/cucumber-reports"
//"json:target/cucumberjson-reports"
//"junit:target/cucumberxmld-reports"