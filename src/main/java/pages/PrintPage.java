package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrintPage extends PageBase{

	public PrintPage(WebDriver driver) {
		super(driver);
	  jse =(JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	@FindBy(css="div.order-number")
	public WebElement orderNumbertxt;

	@FindBy(xpath="/html/body/print-preview-app//print-preview-sidebar//print-preview-button-strip//cr-button[2]")
	public WebElement cancelPrintBtn;

	public void getPdf()
	{
		jse.executeScript("window.print = function(){};");
	}
}
