package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CompareProducts;
import pages.HomePage;
import pages.ProductDetailsPage;

public class CompareProductsTest extends TestBase{
	
	//1-search for first product
	//2-add first product to compare list
	//3-search for second product
	//4-add second product to compare list
	//5- clear list
	String firstProduct="Apple MacBook Pro";
	String secondProduct="Asus Laptop";
	
	HomePage homeObject;
	ProductDetailsPage productObject;
	CompareProducts compareObject;
	@Test(priority = 0 )
	public void CanUserSearchForFirstProductWithAutoComplete()
	{
		homeObject = new HomePage(driver);
		productObject = new ProductDetailsPage(driver);
		homeObject.searchProductAutoComplete(firstProduct);
		Assert.assertTrue(productObject.productName.getText().contains(firstProduct));
	}
	@Test(priority = 1 ,dependsOnMethods = "CanUserSearchForFirstProductWithAutoComplete")
	public void CanUserAddProdcutFirstToCompareList()
	{
		productObject.addProductToCompareList();
		Assert.assertTrue(productObject.barNotification.getText().contains("The product has been added to your"));
	}
	@Test(priority = 2)
	public void CanUserSearchForSecondProductWithAutoComplete()
	{
		homeObject = new HomePage(driver);
		productObject = new ProductDetailsPage(driver);
		homeObject.searchProductAutoComplete(secondProduct);
		Assert.assertTrue(productObject.productName.getText().contains(secondProduct));
	}
	@Test(priority = 3 ,dependsOnMethods = "CanUserSearchForSecondProductWithAutoComplete")
	public void CanUserAddProdcutSecondToCompareList()
	{
		productObject.addProductToCompareList();
		Assert.assertTrue(productObject.barNotification.getText().contains("The product has been added to your"));
	}
	@Test(priority = 4)
	public void IsProductsToBeCompareRight()
	{
		compareObject = new CompareProducts(driver);
		driver.navigate().to(url+"compareproducts");
		System.out.println(compareObject.firstProdcutToCompare.getText());
		System.out.println(compareObject.secondProdcutToCompare.getText());
		
		Assert.assertTrue(compareObject.firstProdcutToCompare.getText().contains(firstProduct));
		Assert.assertTrue(compareObject.secondProdcutToCompare.getText().contains(secondProduct));
	}
	@Test(priority = 5)
	public void CanUserClearCompareList()
	{
		compareObject = new CompareProducts(driver);
		driver.navigate().to(url+"compareproducts");
		compareObject.clearCompareList();
		Assert.assertTrue(compareObject.compareListNotification.getText().contains("You have no items to compare."));
	}

}
