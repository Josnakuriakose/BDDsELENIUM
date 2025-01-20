package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver driver;

	    public void appLoginPage() throws Exception {
	        WebDriverManager.edgedriver().setup(); // Uncomment if you use WebDriverManager
	        EdgeOptions options= new EdgeOptions();
	    	//options.addArguments("--headless");
		    //options.addArguments("--disable-gpu");
		    //options.addArguments("--window-size=1920,1080");
		     driver = new EdgeDriver(options);
	    
	        driver.manage().window().maximize();
	        driver.get("https://staging-backoffice.send2.com/authentication/side-login"); 
	    }
}
