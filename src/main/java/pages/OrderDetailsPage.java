package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends PageBase{

	public OrderDetailsPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(linkText="Print")
	WebElement printOrderInfoBtn;
	
	@FindBy(linkText="PDF Invoice")
	WebElement downloadPdfInvoiceBtn;
	
	
	
	@FindBy(css="div.order-number")
	public WebElement orderNumbertxt;
	
	public void printOrderInfo() throws InterruptedException
	{
		clickButton(printOrderInfoBtn);
		Thread.sleep(3000);
		
	}
	public void downlaodPdfInovice()
	{
		clickButton(downloadPdfInvoiceBtn);
	}
	

}
