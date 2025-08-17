package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDT_JavaPropertiesFile extends TestBase
{

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	char gender =LoadProperties.userdata.getProperty("gender").charAt(0);
	String fname =LoadProperties.userdata.getProperty("firstname");
	String lname=LoadProperties.userdata.getProperty("lastname");
	String email =LoadProperties.userdata.getProperty("email");
	String password=LoadProperties.userdata.getProperty("password");
	
	
	@Test(priority = 1)
	public void CanUserRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		registerObject = new UserRegistrationPage(driver);
		homeObject.openRegisterPage();
		registerObject.userRegistration(gender,fname, lname, email,password);
		Assert.assertTrue(registerObject.successfullRegisterMessage.getText().contains("Your registration completed"));
		registerObject.logout();
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(email, password);
		Assert.assertTrue(registerObject.logoutLink.isDisplayed());
		registerObject.logout();
	}
	
}
