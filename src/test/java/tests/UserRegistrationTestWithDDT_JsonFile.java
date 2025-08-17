package tests;


import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JsonReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDT_JsonFile extends TestBase
{

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;



	@Test(priority = 1)
	public void CanUserRegisterSuccessfully() throws IOException, ParseException
	{
		JsonReader reader = new JsonReader();
		reader.getJsonData();
		homeObject = new HomePage(driver);
		registerObject = new UserRegistrationPage(driver);
		homeObject.openRegisterPage();
		registerObject.userRegistration('m',reader.fname,reader.lname,reader.email,reader.password);
		Assert.assertTrue(registerObject.successfullRegisterMessage.getText().contains("Your registration completed"));
		registerObject.logout();
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(reader.email, reader.password);
		Assert.assertTrue(registerObject.logoutLink.isDisplayed());
		registerObject.logout();
	}

}
