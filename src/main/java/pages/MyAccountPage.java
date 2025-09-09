package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(linkText="Change password")
	WebElement chnagePasswordLink;
	
	@FindBy(id="OldPassword")
	WebElement oldPasswrodTxtBox;
	
	@FindBy(id="NewPassword")
	WebElement newPasswrodTxtBox;
	
	@FindBy(id="ConfirmNewPassword")
	WebElement confirmPasswrodTxtBox;
	
	@FindBy(css="button.button-1.change-password-button")
	WebElement changePasswrodBtn;
	
	@FindBy(css="div.bar-notification.success")
	public WebElement changedPasswordNotification;
	
	@FindBy(css="span.close")
	WebElement closeChangedPasswordNotification;
	
	public void openChnagePasswordPage()
	{
		clickButton(chnagePasswordLink);
	}
	
	public void changePassword(String oldPasswrod , String newPasswrod)
	{
		sendTxtElmentText(oldPasswrodTxtBox, oldPasswrod);
		sendTxtElmentText(newPasswrodTxtBox, newPasswrod);
		sendTxtElmentText(confirmPasswrodTxtBox, newPasswrod);
		clickButton(changePasswrodBtn);
	}
	
	public void closeChangedPasswordMessage()
	{
		clickButton(closeChangedPasswordNotification);
	}
}
