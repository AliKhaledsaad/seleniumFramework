package tests;



import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDT_DataProvider extends TestBase
{

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	@DataProvider(name="userData")
	public static Object[] [] userData()
	{
		return new Object[] [] {
			{'m',"ahmed","ali","ahmedali1@Test.com","test1password"},
			{'f',"assma","samir","assmasamir1@Test.com","test2password"}
		};
	}
	
	
	@Test(priority = 1,dataProvider="userData")
	public void CanUserRegisterSuccessfully(char gender,String fname ,String lname ,String email ,String password)
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
