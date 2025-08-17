package tests;


import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;



import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDT_CSV extends TestBase
{

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;

	
	CSVReader reader;
	@Test(priority = 1)
	public void CanUserRegisterSuccessfully() throws CsvValidationException, IOException
	{
		String csvFilePath = System.getProperty("user.dir")+"/src/test/java/data/userRegisterData.csv";
		reader = new CSVReader(new FileReader(csvFilePath));
		String[] csvCells;
		while((csvCells = reader.readNext() )!=null)
		{
			char gender = csvCells[0].charAt(0);
			String fname= csvCells[1];
			String lname=csvCells[2] ;
			String email =csvCells[3];
			String password=csvCells[4];
			
		
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
	
}
