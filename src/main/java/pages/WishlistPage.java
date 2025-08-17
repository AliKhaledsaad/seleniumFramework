package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistPage extends PageBase{

	public WishlistPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="td.product")
	public WebElement productName;
	
	@FindBy(name="updatecart")
	WebElement removeProduct;
	
	@FindBy(id="updatecart")
	WebElement updateCartBtn;
	
	@FindBy(css="div.no-data")
	public WebElement updatedWishlistNotification;
	
	public void removeProductFromWishList()
	{
		clickButton(removeProduct);
	}

}
