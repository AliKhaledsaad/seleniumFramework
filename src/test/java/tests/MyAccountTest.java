package tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

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
	Faker fake =new Faker();  
	String fname = fake.name().firstName();
	String lname = fake.name().lastName();
	String email =fake.internet().emailAddress();
	String password = fake.number().digits(8).toString();
	String newPassword= fake.number().digits(8).toString();
	
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
	loginObject.userLogin(email, newPassword);
	Assert.assertTrue(registerObject.logoutLink.isDisplayed());
	}
}
