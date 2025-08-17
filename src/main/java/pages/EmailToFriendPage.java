package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailToFriendPage extends PageBase{

	public EmailToFriendPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(id="FriendEmail")
	WebElement friendEmailTxtBox;
	
	@FindBy(id="PersonalMessage")
	WebElement messageTxtBox;
	
	@FindBy(css="button.button-1.send-email-a-friend-button")
	WebElement sendEmailBtn;
	
	@FindBy(css="div.result")
	public WebElement emailToFriendsuccessfullNotification;

	public void emailToFriend(String friendEmail,String message)
	{
		sendTxtElmentText(this.friendEmailTxtBox, friendEmail);
		sendTxtElmentText(messageTxtBox, message);
		clickButton(sendEmailBtn);
		
	}

}
