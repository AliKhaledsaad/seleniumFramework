package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.CheckOutPage;
import pages.HomePage;
import pages.OrderDetailsPage;
import pages.PrintPage;
import pages.ProductDetailsPage;
import tests.TestBase;

public class E2ETests extends TestBase{
	String fName ="test1";
	String lName ="Test";
	String email ="testusersdsda20@checkout.com";
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
	HomePage homeObject;
	ProductDetailsPage productObject;
	CartPage cartObject ;
	CheckOutPage checkoutObject;
	OrderDetailsPage orderDetailsObject;
	PrintPage printObject;
	@Given("user is on Home Page")
	public void user_is_on_home_page() {
	  Assert.assertTrue(driver.getCurrentUrl().contains("https://localhost:59579"));
	}
	@When("user search for {string}")
	public void user_search_for(String string) {
		homeObject = new HomePage(driver);
		productObject = new ProductDetailsPage(driver);
		homeObject.searchProductAutoComplete(string);
		Assert.assertTrue(productObject.productName.getText().contains(string));
	}
	@When("choose to buy {int} item")
	public void choose_to_buy_item(Integer int1) throws InterruptedException {
		productObject = new ProductDetailsPage(driver);
		cartObject = new CartPage(driver);
		productObject.addProdcutToCart();
		Thread.sleep(2000);
		driver.navigate().to(url+"cart");
		Assert.assertTrue(cartObject.productName.getText().contains(keyWord));
		Assert.assertTrue(cartObject.totalPrice.getText().contains(price));
	}
	@When("moves to checkout cart and enter personal details on checkout page and place the order")
	public void moves_to_checkout_cart_and_enter_personal_details_on_checkout_page_and_place_the_order() throws InterruptedException {
		cartObject = new CartPage(driver);
		checkoutObject = new CheckOutPage(driver);
		cartObject.openCheckoutPageAsGuest();
		checkoutObject.checkoutCart(fName, lName, email, country, state, city, address1, zipCode, phoneNumber, shipingOption, paymentOption, creditCardType, cardholderName, cardNumber, expireMonthDate, expireYearDate, CardCode);
		Thread.sleep(7000);
		Assert.assertTrue(checkoutObject.checkoutProcesssedNotification.getText().contains("Your order has been successfully processed!"));
		
	   
	}
	@Then("he can view ordr successfully purashed message and download the invoice")
	public void he_can_view_ordr_successfully_purashed_message_and_download_the_invoice() throws InterruptedException {
		checkoutObject.openOrderDetailsPage();
		orderDetailsObject = new OrderDetailsPage(driver);
		printObject = new PrintPage(driver);
		String orderNumber = orderDetailsObject.orderNumbertxt.getText();
		orderDetailsObject.printOrderInfo();
		printObject.getPdf();
		Assert.assertTrue(printObject.orderNumbertxt.getText().contains(orderNumber));
	}

}
