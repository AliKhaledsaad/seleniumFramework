package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.ProductDetailsPage;

public class AddProductToCartTest extends TestBase{

	
	String keyWord="Apple MacBook Pro";
	String price = "3,600.00";
	String Changedprice = "7,200.00";
	HomePage homeObject;
	ProductDetailsPage productObject;
	CartPage cartObject;
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
	
	@Test(dependsOnMethods = ("CanGuestAddProductToCart"),priority = 3)
	public void CanGuestChangeQuantityInCart() throws InterruptedException
	{
		cartObject = new CartPage(driver);
		cartObject.changeProductQuantity("4");
		Thread.sleep(5000);
		System.out.println(cartObject.totalPrice.getText());
		Assert.assertTrue(cartObject.totalPrice.getText().contains(Changedprice));
	}
	
	@Test(dependsOnMethods = "CanGuestAddProductToCart",priority = 4)
	public void CanGuestRemoveProductFromCart()
	{
		cartObject = new CartPage(driver);
		cartObject.removeProductFrmoCart();
		Assert.assertTrue(cartObject.updatedCartMessage.getText().contains("Your Shopping Cart is empty!"));
	}
}
