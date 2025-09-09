package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
		action = new Actions(driver);
	}
	@FindBy(linkText ="Register")
	WebElement registerLink;
	
	@FindBy(linkText="Log in")
	WebElement loginLink;
	
	@FindBy(linkText="My account")
	WebElement myAccountLink;
	
	@FindBy(id="small-searchterms")
	WebElement searchBarTxtBox;
	
	@FindBy(css="button.button-1.search-box-button")
	WebElement searchBtn;
	
	@FindBy(id="ui-id-1")
	List<WebElement> searchList;
	
	@FindBy(linkText = "Contact us")
	WebElement contactUsLink;
	
	@FindBy(id="customerCurrency")
	public WebElement currencyDropList;
	
	@FindBy(css="span.price.actual-price")
	public WebElement priceTxt;
	
	@FindBy(linkText= "Computers")
	WebElement computersMenu;
	
	@FindBy(linkText = "Notebooks")
	WebElement notebooksMenu;
	
	@FindBy(css="strong.current-item")
	public WebElement currentItemBar;
	
	public void openRegisterPage()
	{
		clickButton(registerLink);
	}
	
	public void openLoginPage()
	{
		clickButton(loginLink);
	}
	
	public void searchProduct(String productKeyWord)
	{
		sendTxtElmentText(searchBarTxtBox, productKeyWord);
		clickButton(searchBtn);
	}
	
	public void searchProductAutoComplete(String productKeyWord)
	{
		sendTxtElmentText(searchBarTxtBox, productKeyWord);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			System.out.println("error occured : "+e.getMessage());
		}
		clickButton(searchList.getFirst());
	}
	
	public void openContactUsPage()
	{
		clickButton(contactUsLink);
	}
	
	public void changeCurrencyToEuro()
	{
		select = new Select(currencyDropList);
		select.selectByIndex(1);
		select.getFirstSelectedOption().click();
		
		
	}
	
	public void selectNotbookMenu() throws InterruptedException
	{
		action.moveToElement(computersMenu).perform();
		notebooksMenu.click();
	}
	

}
