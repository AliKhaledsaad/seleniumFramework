package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class ProductHoverMenuTest extends TestBase{

	HomePage homeObject;

	@Test
	public void CanUserSelectFromMainMenu() throws InterruptedException 
	{
		homeObject = new HomePage(driver);

		homeObject.selectNotbookMenu();
		Assert.assertTrue(homeObject.currentItemBar.getText().contains("Notebooks"));
	}
}
