package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends PageBase{

	public CartPage(WebDriver driver) {
		super(driver);
		
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
	
	public void changeProductQuantity(String quantity)
	{
		//clearTxtElement(productQuantity);
		productQuantity.clear();
		sendTxtElmentText(productQuantity, quantity);
		productQuantity.submit();
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
