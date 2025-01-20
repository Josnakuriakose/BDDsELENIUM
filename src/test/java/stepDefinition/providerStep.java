package stepDefinition;

import org.openqa.selenium.WebDriver;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy.Provider;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import send2WebBackOffice.LoginPage;
import send2WebBackOffice.ProviderPage;

public class providerStep {
	

	    public ProviderPage objProvider = new ProviderPage();
	    public LoginPage objuser11=new LoginPage();
	    
	    
	    @Given("the user is on the home page")
	    public void user_is_on_home_page() throws Exception {
	    	objuser11 = new LoginPage();
			objuser11.appSuperAdminLoginName();
			objuser11.appSuperAdminLoginPassword();
			objuser11.appLoginClickLogin();
	         // Assuming this method is part of the Provider class
	    	//objProvider.navigateToHomePage();
	    }

	    @Given("user is on the provider page")
	    public void user_is_on_provider_page() throws Exception {
	    	objProvider.clickProvidersTile();
	          // Assuming this method clicks the Providers tile
	    }

	    @When("the user clicks on the Add Provider button")
	    public void user_clicks_on_add_provider_button() throws Exception {
	    	objProvider.clickAddProviderButton();
	          // Assuming this method clicks the Add Provider button
	    }

	    @When("the user fills in all required provider fields")
	    public void user_fills_in_provider_fields() throws Exception {
	         
	   objProvider.fillProviderFields();
	        // Assuming the fillProviderFields method fills in the provider form fields with provided data
	    }

	    @When("the user clicks the Submit button")
	    public void user_clicks_submit_button() throws Exception {
	    	objProvider.clickSubmitButton();
	        // Assuming this method clicks the submit button after filling the form
	    }

	    @Then("the new provider should be created")
	    public void new_provider_should_be_created() throws Exception {
	        // Assuming there's a method to get the success message
	    	objProvider.getSuccessProvider();
	        
	    }

	    @Then("the new provider should be displayed in the provider list")
	    public void new_provider_should_be_displayed() throws Exception {
	       // Checking if the new provider exists in the list
	       
	    }
	    @Given("user is in newly created provider page")
	    public void user_is_in_newly_created_provider_page() throws InterruptedException {
	    	objProvider.clickProvidersTile();
	    	objProvider.clickAddProviderButton();
	    	objProvider.fillProviderFields();
	    	objProvider.clickSubmitButton();
	    	objProvider.getSuccessProvider();
	    	
	    	
	    }
	    @When("user click on Delete button")
	    public void user_click_on_delete_button() throws InterruptedException {
	    	objProvider.deleteProvider();
	    	
	    }
	    @Then("The provider should delete successfully")
	    public void the_provider_should_delete_successfully() throws InterruptedException {
	    	objProvider.deleteConfirmation();
	        
	    }

	}



