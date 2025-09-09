package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.HomePage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class UserRegistration extends TestBase
{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	@Given("the user in the home page")
	public void the_user_in_the_home_page() {
		homeObject = new HomePage(driver);
	}
	@When("I click on register link")
	public void i_click_on_register_link() {
		homeObject = new HomePage(driver);
		homeObject.openRegisterPage();
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}
	@When("i entered {string}, {string} , {string} , {string} , {string}")
	public void i_entered(String string, String string2, String string3, String string4, String string5) {
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration(string.charAt(0),string2,string3,string4,string5);
	}
	@Then("the registration successfully page should be displayed")
	public void the_registration_successfully_page_should_be_displayed() 
	{
		registerObject = new UserRegistrationPage(driver);
	  Assert.assertTrue(registerObject.successfullRegisterMessage.getText().contains("Your registration completed"));
	  registerObject.logout();
	}
}
