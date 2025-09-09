package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CartPage extends PageBase{

	public CartPage(WebDriver driver) {
		super(driver);
		action = new Actions(driver);
	}

	@FindBy(css="a.product-name")
	public WebElement productName;
	
	@FindBy(css="span.product-unit-price")
	WebElement productPrice;
	
	@FindBy(css="input.qty-input")
	public WebElement productQuantity;
	
	@FindBy(css="span.product-subtotal")
	public WebElement totalPrice;
	
	@FindBy(name="updatecart")
	WebElement removeProductBtn;
	
	@FindBy(css="div.no-data")
	public WebElement updatedCartMessage;
	
	@FindBy(id="checkout")
	WebElement checkoutBtn;
	
	@FindBy(id="termsofservice")
	WebElement agreeOnTermsBtn;
	
	@FindBy(css="button.button-1.checkout-as-guest-button")
	WebElement checkoutAsGuestBtn;
	
	public void changeProductQuantity(String quantity) throws InterruptedException
	{
		//clearTxtElement(productQuantity);
		
		action.doubleClick(productQuantity).sendKeys(productQuantity, quantity).click(totalPrice).build().perform();
		//productQuantity.clear();
		//Thread.sleep(1000);
		//sendTxtElmentText(productQuantity, quantity);
	//	productQuantity.submit();
		Thread.sleep(1000);
	}
	public void removeProductFrmoCart()
	{
		clickButton(removeProductBtn);
	}
	
	public void openCheckoutPageAsGuest()
	{
		clickButton(agreeOnTermsBtn);
		clickButton(checkoutBtn);
		clickButton(checkoutAsGuestBtn);
	}
	public void openCheckoutPageAsRegisteredUser()
	{
		clickButton(agreeOnTermsBtn);
		clickButton(checkoutBtn);
	}
	
	
	
	
	
	
}
