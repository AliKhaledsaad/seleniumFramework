package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase
{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(css="div.product-name")
	public WebElement productName;
	
	@FindBy(css = "button.button-2.email-a-friend-button")
	WebElement emailToFriendBtn;
	
	@FindBy(id="add-to-wishlist-button-4")
	WebElement addToWishlistBtn;
	
	@FindBy(css="button.button-2.add-to-compare-list-button")
	WebElement addToCompareListBtn;
	
	@FindBy(css="div.bar-notification.success")
	public WebElement barNotification;
	
	@FindBy(id="add-to-cart-button-4")
	WebElement addToCartBtn;
	
	public void openEmailToFriendPage()
	{
		clickButton(emailToFriendBtn);
	}
	public void addProductToWishlist()
	{
		clickButton(addToWishlistBtn);
	}
	
	public void addProductToCompareList()
	{
		clickButton(addToCompareListBtn);
	}
	public void addProdcutToCart()
	{
		clickButton(addToCartBtn);
	}

}
