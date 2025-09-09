package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase
{

	String name="test1";
	String email="test32231@gmail.com";
	String message = "Hello";
	HomePage homeObject;
	ContactUsPage contactUsObject;
	
	@Test
	public void CanUserContactUs()
	{
		homeObject = new HomePage(driver);
		contactUsObject = new ContactUsPage(driver);
		homeObject.openContactUsPage();
		contactUsObject.contactUs(name, email, message);
		Assert.assertTrue(contactUsObject.contactUsSuccessfullyNotification.getText().equalsIgnoreCase("Your enquiry has been successfully sent to the store owner."));
		
	}
}
