package tests;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDT_JavaFaker extends TestBase
{

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	Faker fake =new Faker();  
	String fname = fake.name().firstName();
	String lname = fake.name().lastName();
	String email =fake.internet().emailAddress();
	String password = fake.number().digits(8).toString();
	@Test
	public void CanUserRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		registerObject = new UserRegistrationPage(driver);
		homeObject.openRegisterPage();
		registerObject.userRegistration('m',fname, lname, email,password);
		Assert.assertTrue(registerObject.successfullRegisterMessage.getText().contains("Your registration completed"));
	}
	
	@Test(dependsOnMethods = "CanUserRegisterSuccessfully")
	public void CanUserLogoutSuccessfully()
	{
		registerObject.logout();
	}
	
	@Test(dependsOnMethods ="CanUserLogoutSuccessfully" )
	public void CanUserLoginSuccessfully()
	{
	homeObject.openLoginPage();
	loginObject = new LoginPage(driver);
	loginObject.userLogin(email, password);
	Assert.assertTrue(registerObject.logoutLink.isDisplayed());
	}
}
