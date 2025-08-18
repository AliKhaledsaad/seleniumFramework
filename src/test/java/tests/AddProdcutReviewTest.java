package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.UserRegistrationPage;

public class AddProdcutReviewTest extends TestBase{

	String keyWord="Mac";
	String reviewTitle="mac review";
	String reviewText="good product";
	int rating=5;
	char gender ='m';
	String fname = "ali22";
	String lname = "saad22";
	String email = "test3xxzzzx30@gmail.com";
	String password="addsssszzzz78z";
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	ProductDetailsPage productObject;
	ProductReviewPage productReviewObject;
	
	@Test(alwaysRun = true , priority = 1)
	public void CanUserRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		registerObject = new UserRegistrationPage(driver);
		homeObject.openRegisterPage();
		registerObject.userRegistration(gender, fname, lname, email,password);
		Assert.assertTrue(registerObject.successfullRegisterMessage.getText().contains("Your registration completed"));
	}
	@Test(dependsOnMethods = "CanUserRegisterSuccessfully")
	public void CanUserSearchForProductWithAutoComplete()
	{
		homeObject = new HomePage(driver);
		productObject = new ProductDetailsPage(driver);
		homeObject.searchProductAutoComplete(keyWord);
		Assert.assertTrue(productObject.productName.getText().contains(keyWord));
	}
	@Test(dependsOnMethods = "CanUserSearchForProductWithAutoComplete" )
	public void CanUserAddProductReview()
	{
		productReviewObject = new ProductReviewPage(driver);
		productReviewObject.addProductReview(reviewTitle, reviewText, rating);
		Assert.assertTrue(productReviewObject.reviewSuccessfullyAddedNotification.isDisplayed());
		productReviewObject.closeAddedReviewNotification();
	}
	@Test(dependsOnMethods = "CanUserAddProductReview")
	public void CanUserLogoutSuccessfully()
	{
		registerObject.logout();
	}
}
