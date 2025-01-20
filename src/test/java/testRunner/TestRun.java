package testRunner;
 
import org.junit.runner.RunWith;
 
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(
//features={".//Features"},
		   //features={".//Feature/Login.feature"},
	  //features={".//Feature/Provider.feature"},
			  features={".//Feature/CustomerManagement.feature"},
        glue={"stepDefinition","hooks"},
        		plugin= {
        				"pretty", "html:JunitReport/myreport.html",
        			    "json:target/cucumber.json",
        			    "junit:target/cucumber-report.xml",
        			    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        		      },dryRun = false
      ,publish=true
      ,tags =  "@Regressions"
)
public class TestRun {
 
}