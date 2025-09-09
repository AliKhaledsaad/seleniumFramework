package tests;



import org.testng.Assert;
import org.testng.annotations.Test;



import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase
{

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	
	@Test
	public void CanUserRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		registerObject = new UserRegistrationPage(driver);
		homeObject.openRegisterPage();
		registerObject.userRegistration('m', "mona", "ahmed", "test11112@gmail.com","1111118");
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
	loginObject.userLogin("test3@gmail.com", "12345678");
	Assert.assertTrue(registerObject.logoutLink.isDisplayed());
	}
}
