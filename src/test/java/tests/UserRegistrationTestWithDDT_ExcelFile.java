package tests;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDT_ExcelFile extends TestBase
{

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;

	@DataProvider(name="userdata")
	public Object[][] userRegisterData() throws IOException
	{
		ExcelReader excelReader = new ExcelReader();

		return excelReader.getExcelData();

	}

	@Test(priority = 1,dataProvider = "userdata")
	public void CanUserRegisterSuccessfully(String gender,String fname ,String lname ,String email ,String password)
	{
		homeObject = new HomePage(driver);
		registerObject = new UserRegistrationPage(driver);
		homeObject.openRegisterPage();
		registerObject.userRegistration(gender.charAt(0),fname, lname, email,password);
		Assert.assertTrue(registerObject.successfullRegisterMessage.getText().contains("Your registration completed"));
		registerObject.logout();
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(email, password);
		Assert.assertTrue(registerObject.logoutLink.isDisplayed());
		registerObject.logout();
	}

}
