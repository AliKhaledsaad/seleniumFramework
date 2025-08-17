package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.WishlistPage;

public class AddProductToWishlistTest extends TestBase{

	HomePage homeObject;
	String keyWord="Mac";
	ProductDetailsPage productObject;
	WishlistPage wishlistObject;
	@Test(priority = 1)
	public void CanUserSearchForProductWithAutoComplete()
	{
		homeObject = new HomePage(driver);
		productObject = new ProductDetailsPage(driver);
		homeObject.searchProductAutoComplete(keyWord);
		Assert.assertTrue(productObject.productName.getText().contains(keyWord));
	}
	@Test(priority = 2)
	public void CanUserAddProductToWishList()
	{
		productObject = new ProductDetailsPage(driver);
		wishlistObject = new WishlistPage(driver);
		productObject.addProductToWishlist();
		driver.navigate().to(url+"wishlist");
		Assert.assertTrue(wishlistObject.productName.getText().contains(keyWord));
	}
	@Test(priority = 3 ,dependsOnMethods = "CanUserAddProductToWishList")
	public void CanUserRemoveProductFromWishList()
	{
		wishlistObject = new WishlistPage(driver);
		wishlistObject.removeProductFromWishList();
		Assert.assertTrue(wishlistObject.updatedWishlistNotification.getText().contains("The wishlist is empty!"));
	}
}
