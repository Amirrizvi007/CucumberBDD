package TestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features={".//Features/LoginFeature.feature"},
		glue="StepDefinition",
		dryRun=false,
		monochrome=true,
		tags ="@Sanity",//scenarios under @sanity tag will be executed
		//plugin= {"pretty","html:target/cucumber-reports/reports1.html"}
		plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		
		)

public class Run extends AbstractTestNGCucumberTests
{
// this class will be empty
}
