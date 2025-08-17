package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends PageBase{

	public SearchResultPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css="h2.product-title")
	public WebElement productTitle;

	@FindBy(linkText="Apple MacBook Pro")
	WebElement productLink;
	
	public void openProudctDetailsPage()
	
	{
		
		clickButton(productLink);
	}
	

}
