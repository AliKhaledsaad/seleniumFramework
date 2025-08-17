package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase{

	public ProductReviewPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="AddProductReview_Title")
	WebElement reviewTitleTxtBox;
	
	@FindBy(id="AddProductReview_ReviewText")
	WebElement reviewTextTxtBox;
	
	@FindBy(name = "AddProductReview.Rating")
	List<WebElement> ratingRadioBtn;
	
	@FindBy(id="add-review")
	WebElement submitReviewBtn;
	
	@FindBy(css="span.close")
	WebElement closeAddedReviewNotification;
	
	@FindBy(css="div.bar-notification.success")
	public WebElement reviewSuccessfullyAddedNotification;
	public void addProductReview(String reviewTitle,String reviewText , int rating)
	{
		sendTxtElmentText(reviewTitleTxtBox, reviewTitle);
		sendTxtElmentText(reviewTextTxtBox, reviewText);
		clickButton(ratingRadioBtn.get(rating));
		clickButton(submitReviewBtn);
	}
	
	public void closeAddedReviewNotification()
	{
		clickButton(closeAddedReviewNotification);
	}

}
