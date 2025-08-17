package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class ChangeCurrencyTest extends TestBase
{

	HomePage homeObject;
	@Test
	public void CanUserChangeCurrencyToEuro() throws InterruptedException
	{
		homeObject = new HomePage(driver);
		homeObject.changeCurrencyToEuro();

		System.out.println(homeObject.priceTxt.getText());
		Thread.sleep(4000);
		Assert.assertTrue(homeObject.priceTxt.getText().contains("€"));
	}
}
