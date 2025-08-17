package tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase
{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	MyAccountPage myAccountObject;
	LoginPage loginObject;
	
	char gender ='m';
	String fname = "ali";
	String lname = "saad";
	String email = "test2322332333@gmail.com";
	String password="a12345678z";
	String newPassword="z123456a";
	
	@Test(priority=1,alwaysRun = true)
	public void CanUserRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		registerObject = new UserRegistrationPage(driver);
		homeObject.openRegisterPage();
		registerObject.userRegistration(gender,fname, lname,email,password);
		Assert.assertTrue(registerObject.successfullRegisterMessage.getText().contains("Your registration completed"));
	}
	
	@Test(dependsOnMethods = "CanUserRegisterSuccessfully")
	public void RegisteredUserCanChangePasswrod()
	{
		myAccountObject = new MyAccountPage(driver);
		registerObject.openMyAccountPage();
		myAccountObject.openChnagePasswordPage();
		myAccountObject.changePassword(password,newPassword);
		Assert.assertTrue(myAccountObject.changedPasswordNotification.isDisplayed());
		
	}
	@Test(dependsOnMethods = "RegisteredUserCanChangePasswrod")
	public void CanUserLogoutSuccessfully()
	{
		myAccountObject.closeChangedPasswordMessage();
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(myAccountObject.changedPasswordNotification));
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
