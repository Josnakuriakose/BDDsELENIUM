package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import core.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends Base{

	Base objuser;
	@Before
    public void setup() throws Exception
    {
	Base objuser = new Base();
	objuser.appLoginPage();
	}

	@After
	public void tearDown(Scenario scenario) {
	    if (scenario.isFailed()) {
	        // Assuming 'driver' is an instance of WebDriver
	        if (driver instanceof TakesScreenshot) {
	            byte[] screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	            scenario.attach(screenshotAs, "image/png", scenario.getName());
	        } else {
	            System.out.println("Driver does not support screenshot capture");
	        }
	    }
 
	    if (driver != null) {
	      driver.quit();
	    }
	}
}
