package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailToFriendPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchResultPage;
import pages.UserRegistrationPage;

public class EmailProductToFriendTest extends TestBase
{

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	ProductDetailsPage productDetailsObject;
	EmailToFriendPage emailToFriendObject;
	SearchResultPage searchObject;
	
	String friendEmail="afddfsf2@gmail.com";
	String productKeyWord="Apple MacBook Pro";
	String message="First Test product email";
	@Test
	public void CanUserRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		registerObject = new UserRegistrationPage(driver);
		homeObject.openRegisterPage();
		registerObject.userRegistration('m', "mona", "ahmed", "test48@gmail.com","1dsasdas11");
		Assert.assertTrue(registerObject.successfullRegisterMessage.getText().contains("Your registration completed"));
	}
	@Test(dependsOnMethods = "CanUserRegisterSuccessfully")
	public void CanUserSearchForProduct()
	{
		
	 	homeObject = new HomePage(driver);
	 	searchObject = new SearchResultPage(driver);
	 	registerObject.continueToHomePage();
	 	homeObject.searchProduct(productKeyWord);
	 	Assert.assertTrue(searchObject.productTitle.getText().contains(productKeyWord));
	}
	@Test(dependsOnMethods = "CanUserSearchForProduct")
	public void CanUserEmailProductToFriend()
	{
		productDetailsObject = new ProductDetailsPage(driver);
		emailToFriendObject = new EmailToFriendPage(driver);
		searchObject = new SearchResultPage(driver);
		searchObject.openProudctDetailsPage();
		productDetailsObject.openEmailToFriendPage();
		emailToFriendObject.emailToFriend(friendEmail,message);
		Assert.assertTrue(emailToFriendObject.emailToFriendsuccessfullNotification.getText().contains("Your message has been sent."));
		
	}
	@Test(dependsOnMethods = "CanUserEmailProductToFriend")
	public void CanUserLogoutSuccessfully()
	{
		registerObject.logout();
	}
	
}
