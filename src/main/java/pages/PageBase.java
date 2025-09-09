package pages;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageBase {
	protected WebDriver driver;
	public JavascriptExecutor jse;
	public Select select;
	public Actions action;
	public WebDriverWait wait;
	
	public PageBase(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	protected static void clickButton(WebElement button)
	{
		button.click();
	}
	protected static void sendTxtElmentText(WebElement txtElement,String text)
	{
		txtElement.sendKeys(text);
	}
	protected static void clearTxtElement(WebElement txtElement)
	{
		txtElement.clear();
	}
  
}
