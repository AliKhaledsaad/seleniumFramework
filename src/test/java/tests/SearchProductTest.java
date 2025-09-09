package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.SearchResultPage;

public class SearchProductTest extends TestBase
{
	
	String productKeyWord="Apple MacBook Pro";
	HomePage homeObject;
	SearchResultPage searchObject;

	@Test
	public void CanUserSearchForProduct()
	{
	 	homeObject = new HomePage(driver);
	 	searchObject = new SearchResultPage(driver);
	 	homeObject.searchProduct(productKeyWord);
	 	Assert.assertTrue(searchObject.productTitle.getText().equalsIgnoreCase(productKeyWord));
	}
}
