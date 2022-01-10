package runners;




import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;





@CucumberOptions(features = { "src/test/resources/FeatureFiles" }, glue = { "steps" }, tags = "@AmazonTest", monochrome = true, plugin = {
		"html:target/cucumber-html-report/cucumber.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })


public class PositiveTest  extends AbstractTestNGCucumberTests  {
	
	
}


