package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.CartPage;
import pages.CheckOutPage;
import pages.HomePage;
import pages.OrderDetailsPage;
import pages.PrintPage;
import pages.ProductDetailsPage;
import pages.UserRegistrationPage;

public class GuestCheckoutCartTest extends TestBase {

	
	Faker fake =new Faker();  
	String fname = fake.name().firstName();
	String lname = fake.name().lastName();
	String email =fake.internet().emailAddress();
	String password = fake.number().digits(8).toString();
	String country ="Egypt";
	String state ="Cairo";
	String city ="giza";
	String address1 ="giza1";
	String zipCode ="123";
	String phoneNumber ="0000000000";
	int shipingOption=1;
	int paymentOption=2;
	String creditCardType ="Visa";
	String cardholderName ="test1Test";
	String cardNumber ="1234567812345678";
	String expireMonthDate ="01";
	String expireYearDate ="2027";
	String CardCode ="777";
	String keyWord="Apple MacBook Pro";
	String price = "3,600.00";
	String Changedprice = "7,200.00";
	HomePage homeObject;
	ProductDetailsPage productObject;
	CartPage cartObject;
	CheckOutPage checkoutObject;
	UserRegistrationPage registerObject;
	OrderDetailsPage orderDetailsObject;
	PrintPage printObject;
	@Test(alwaysRun = true,priority = 1)
	public void CanUserSearchForProductWithAutoComplete()
	{
		homeObject = new HomePage(driver);
		productObject = new ProductDetailsPage(driver);
		homeObject.searchProductAutoComplete(keyWord);
		Assert.assertTrue(productObject.productName.getText().contains(keyWord));
	}
	
	@Test(dependsOnMethods = "CanUserSearchForProductWithAutoComplete" ,priority = 2)
	public void CanGuestAddProductToCart() throws InterruptedException
	{
		productObject = new ProductDetailsPage(driver);
		cartObject = new CartPage(driver);
		productObject.addProdcutToCart();
		Thread.sleep(2000);
		driver.navigate().to(url+"cart");
		Assert.assertTrue(cartObject.productName.getText().contains(keyWord));
		Assert.assertTrue(cartObject.totalPrice.getText().contains(price));
	}
	@Test(dependsOnMethods = "CanGuestAddProductToCart",priority = 3)
	public void CanGuestCheckoutCart() throws InterruptedException
	{
		cartObject = new CartPage(driver);
		checkoutObject = new CheckOutPage(driver);
		cartObject.openCheckoutPageAsGuest();
		checkoutObject.checkoutCart(fname, lname, email, country, state, city, address1, zipCode, phoneNumber, shipingOption, paymentOption, creditCardType, cardholderName, cardNumber, expireMonthDate, expireYearDate, CardCode);
		Thread.sleep(5000);
		Assert.assertTrue(checkoutObject.checkoutProcesssedNotification.getText().contains("Your order has been successfully processed!"));
	}
	@Test(dependsOnMethods = "CanGuestCheckoutCart",priority = 4)
	public void CanGuestPrintOrderInvoicePdf() throws InterruptedException
	{
		cartObject = new CartPage(driver);
		checkoutObject = new CheckOutPage(driver);
		orderDetailsObject = new OrderDetailsPage(driver);
		checkoutObject.openOrderDetailsPage();
		orderDetailsObject = new OrderDetailsPage(driver);
		printObject = new PrintPage(driver);
		String orderNumber = orderDetailsObject.orderNumbertxt.getText();
		orderDetailsObject.printOrderInfo();
		printObject.getPdf();
		Assert.assertTrue(printObject.orderNumbertxt.getText().contains(orderNumber));
	
	}
	
}
