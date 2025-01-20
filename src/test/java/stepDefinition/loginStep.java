package stepDefinition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import send2WebBackOffice.LoginPage;

 
 
public class loginStep  {
	public LoginPage objuser11=new LoginPage();
	
	@Given("User is on login page")
	public void user_is_Send2_login_page() throws Exception {
		objuser11 = new LoginPage();
		objuser11.appSuperAdminLoginName();
		objuser11.appSuperAdminLoginPassword();
	}
 
	@When("User clicks on login button")
	public void user_enter_username_and_password() throws Exception {
		
		objuser11.appLoginClickLogin();
	}
 
	
 
	@Then("User should enter the home page")
	public void user_should_enter_to_home_page() throws Exception {
		objuser11.appHomePageLanding();
	}
}