package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompareProducts extends PageBase{

	public CompareProducts(WebDriver driver) {
		super(driver);
	}
	@FindBy(css="a.clear-list")
	WebElement clearListBtn;
	
	@FindBy(css="div.no-data")
	public WebElement compareListNotification;
	
	@FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div/div[2]/div/table/tbody/tr[3]/td[3]")
	public WebElement firstProdcutToCompare;
	@FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div/div[2]/div/table/tbody/tr[3]/td[2]")
	public WebElement secondProdcutToCompare;
	
	public void clearCompareList()
	{
		clickButton(clearListBtn);
	}

}
