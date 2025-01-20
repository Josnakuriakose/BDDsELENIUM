package stepDefinition;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import send2WebBackOffice.ProviderPage;

public class CustomerManagementStep {
	public providerStep objcustomer=new providerStep();
	@Given("User is login to send2 page")
	public void user_is_login_to_send2_page() throws Exception {
		WebDriver driver=new EdgeDriver();
		objcustomer.user_is_on_home_page();
		((JavascriptExecutor) driver).executeScript("window.open();");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get("https://staging-customer.send2.com/home");
	    
	}
	@Given("User navigate to Customer Management page")
	public void user_navigate_to_customer_management_page() {
	   
	}
	@When("User Export CSV")
	public void user_export_csv() {
	    
	}
	@Then("User should able to Export CSV")
	public void user_should_able_to_export_csv() {
	    
	}



}
